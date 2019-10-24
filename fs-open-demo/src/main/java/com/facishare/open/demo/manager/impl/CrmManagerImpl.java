package com.facishare.open.demo.manager.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facishare.open.demo.beans.CorpAccessToken;
import com.facishare.open.demo.beans.EmployeeVO;
import com.facishare.open.demo.beans.args.CrmQueryArg;
import com.facishare.open.demo.beans.args.DeptAddModifyArg;
import com.facishare.open.demo.beans.args.DeptListArg;
import com.facishare.open.demo.beans.args.DeptUserListArg;
import com.facishare.open.demo.beans.args.UserInfoArg;
import com.facishare.open.demo.beans.args.CrmQueryArg.SearchQuery;
import com.facishare.open.demo.beans.results.CorpUserMapResult;
import com.facishare.open.demo.beans.results.CrmQueryResult;
import com.facishare.open.demo.beans.results.Department;
import com.facishare.open.demo.beans.results.DeptAddResult;
import com.facishare.open.demo.beans.results.DeptListResult;
import com.facishare.open.demo.beans.results.DeptUpdateResult;
import com.facishare.open.demo.beans.results.DeptUserListResult;
import com.facishare.open.demo.beans.results.User;
import com.facishare.open.demo.beans.results.UserResult;
import com.facishare.open.demo.exception.AccessTokenException;
import com.facishare.open.demo.manager.AccessTokenManager;
import com.facishare.open.demo.manager.AddressBookManager;
import com.facishare.open.demo.manager.CrmManager;
import com.facishare.open.demo.utils.OpenAPIUtils;
import com.google.common.collect.Maps;

@Service("crmManager")
public class CrmManagerImpl implements CrmManager {

    @Autowired
    private AccessTokenManager accessTokenManager;

   ;

    @Override
    public CrmQueryResult getCustomerAccounts(String openUserId) throws AccessTokenException{
        SearchQuery searchQuery=new SearchQuery();
        CrmQueryArg arg = new CrmQueryArg();
        CorpAccessToken token = accessTokenManager.getCorpAccessToken();
        arg.setCorpAccessToken(token.getCorpAccessToken());
        arg.setCorpId(token.getCorpId());
        arg.setCurrentOpenUserId(openUserId);
        arg.setApiName("AccountObj");
        arg.setSearchQuery(searchQuery);

        return OpenAPIUtils.queryCrmData(arg);
    }

}
