package com.facishare.open.demo.manager.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facishare.open.demo.beans.CorpAccessToken;
import com.facishare.open.demo.beans.EmployeeVO;
import com.facishare.open.demo.beans.args.v2.CrmQueryArg;
import com.facishare.open.demo.beans.args.DeptAddModifyArg;
import com.facishare.open.demo.beans.args.DeptListArg;
import com.facishare.open.demo.beans.args.DeptUserListArg;
import com.facishare.open.demo.beans.args.UserInfoArg;
import com.facishare.open.demo.beans.args.v2.QueryData;
import com.facishare.open.demo.beans.args.v2.QueryData.DataProjection;
import com.facishare.open.demo.beans.args.v2.QueryData.Filter;
import com.facishare.open.demo.beans.args.v2.QueryData.Order;
import com.facishare.open.demo.beans.args.v2.QueryData.SearchQuery;
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
import com.facishare.open.demo.utils.v2.OpenAPIUtils;
import com.google.common.collect.Maps;

@Service("crmManager")
public class CrmManagerImpl implements CrmManager {

    @Autowired
    private AccessTokenManager accessTokenManager;


    @Override
    public CrmQueryResult getCustomerAccounts(String openUserId) throws AccessTokenException{
    	
        SearchQuery searchQuery=new SearchQuery();
        searchQuery.setFilters(new ArrayList<Filter>());
        searchQuery.setOrders(new ArrayList<Order>());
        CrmQueryArg arg = new CrmQueryArg();
        QueryData data= new QueryData();
        data.setDataObjectApiName("AccountObj");
        data.setSearchQuery(searchQuery);
        CorpAccessToken token = accessTokenManager.getCorpAccessToken();
        arg.setCorpAccessToken(token.getCorpAccessToken());
        arg.setCorpId(token.getCorpId());
        arg.setCurrentOpenUserId(openUserId);
        arg.setData(data);
        return OpenAPIUtils.queryCrmData(arg);
    }
    
    @Override
    public CrmQueryResult getCustomerAccountsV1(String openUserId) throws AccessTokenException{
    	 CorpAccessToken token = accessTokenManager.getCorpAccessToken();
          
        com.facishare.open.demo.beans.args.CrmQueryArg arg = new  com.facishare.open.demo.beans.args.CrmQueryArg();
        arg.setCorpAccessToken(token.getCorpAccessToken());
        arg.setCorpId(token.getCorpId());
        arg.setCurrentOpenUserId(openUserId);
        arg.setApiName("AccountObj");
       
        com.facishare.open.demo.beans.args.CrmQueryArg.SearchQuery searchQuery =new    com.facishare.open.demo.beans.args.CrmQueryArg.SearchQuery();
       
        arg.setSearchQuery(searchQuery);
      
        return com.facishare.open.demo.utils.OpenAPIUtils.queryCrmData(arg);
    }


}
