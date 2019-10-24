package com.facishare.open.demo.manager;

import com.facishare.open.demo.beans.results.CorpUserMapResult;
import com.facishare.open.demo.beans.results.CrmQueryResult;
import com.facishare.open.demo.beans.results.Department;
import com.facishare.open.demo.beans.results.DeptAddResult;
import com.facishare.open.demo.beans.results.DeptListResult;
import com.facishare.open.demo.beans.results.DeptUpdateResult;
import com.facishare.open.demo.beans.results.UserResult;
import com.facishare.open.demo.exception.AccessTokenException;

/**
 * 通讯录数据的管理接口
 * 
 * @author huanghp
 * @date 2015年9月18日
 */
public interface CrmManager {

 
    public CrmQueryResult getCustomerAccounts(String openUserId) throws AccessTokenException;

}
