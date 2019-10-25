package com.facishare.open.demo.utils.v2;


import com.facishare.open.demo.beans.HttpResponseMessageVO;
import com.facishare.open.demo.beans.args.Arg;
import com.facishare.open.demo.beans.args.v2.CrmQueryArg;
import com.facishare.open.demo.beans.args.v2.CrmQueryArg;
import com.facishare.open.demo.beans.results.AppTokenResult;
import com.facishare.open.demo.beans.results.BaseResult;
import com.facishare.open.demo.beans.results.BindAccountResult;
import com.facishare.open.demo.beans.results.CorpAccessTokenResult;
import com.facishare.open.demo.beans.results.CrmAddResult;
import com.facishare.open.demo.beans.results.CrmDescResult;
import com.facishare.open.demo.beans.results.CrmGetResult;
import com.facishare.open.demo.beans.results.CrmQueryResult;
import com.facishare.open.demo.beans.results.DeptAddResult;
import com.facishare.open.demo.beans.results.DeptListResult;
import com.facishare.open.demo.beans.results.DeptUpdateResult;
import com.facishare.open.demo.beans.results.DeptUserListResult;
import com.facishare.open.demo.beans.results.OpenUserIdResult;
import com.facishare.open.demo.beans.results.Result;
import com.facishare.open.demo.beans.results.TextMsgResult;
import com.facishare.open.demo.beans.results.UserResult;
import com.facishare.open.demo.exception.BaseException;
import com.facishare.open.demo.utils.Constants;
import com.facishare.open.demo.utils.HttpTookit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class OpenAPIUtils {

    private static final Logger LOG = LoggerFactory.getLogger(OpenAPIUtils.class);

    /**
     * 环境为：https://open.fxiaoke.com
     */
    private static final String prefix = "https://open.fxiaoke.com";


    /**
     * CRM查询列表 元数据接口
     */
    public static CrmQueryResult queryCrmData(CrmQueryArg arg) {
        String url = prefix + "/cgi/crm/v2/data/query";
        return doPost(url, arg, CrmQueryResult.class);
    }


    private static <T extends BaseResult> T doPost(String url, Arg arg, Class<T> clazz) {
        T t = null;
        Result<String> result = doPost(url, arg);
        if (result.getCode() == 0) {
            t = new Gson().fromJson(result.getData(), clazz);
        }

        if (t != null) {
            return t;
        }

        try {
            t = clazz.newInstance();
            t.setErrorCode(result.getCode());
            t.setErrorMessage(result.getMsg());
        } catch (Exception e) {
            LOG.error("doPost error, details:", e);
        }
        return t;
    }

    private static Result<String> doPost(String url, Arg arg) {
        Result<String> result = new Result<String>();

        try {
            HttpResponseMessageVO resp = HttpTookit.sendPostByJson(url, new Gson().toJson(arg));

            if ("200".equals(resp.getHttpCode())) {
                result.setData(resp.getContent());
            } else {
                result.setCode(Constants.interfaceException.INTERFACE_EXCEPTION.code);
                result.setMsg(Constants.interfaceException.INTERFACE_EXCEPTION.msg.concat(",HTTP Status Code:").concat(
                        resp.getHttpCode()));
            }
        } catch (BaseException e) {
            LOG.error("doPost error, details:", e);
            result.setMsg(e.getMessage());
            result.setCode(e.getCode());
        }

        return result;
    }
}
