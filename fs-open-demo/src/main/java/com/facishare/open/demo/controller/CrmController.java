package com.facishare.open.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.facishare.open.demo.beans.results.CorpUserMapResult;
import com.facishare.open.demo.beans.results.CrmQueryResult;
import com.facishare.open.demo.beans.results.Department;
import com.facishare.open.demo.beans.results.DeptAddResult;
import com.facishare.open.demo.beans.results.DeptListResult;
import com.facishare.open.demo.beans.results.DeptUpdateResult;
import com.facishare.open.demo.beans.results.OpenUserIdResult;
import com.facishare.open.demo.beans.results.UserResult;
import com.facishare.open.demo.exception.AccessTokenException;
import com.facishare.open.demo.manager.AddressBookManager;
import com.facishare.open.demo.manager.CrmManager;
import com.facishare.open.demo.utils.Constants;

@RestController
@RequestMapping(value = "/crm", produces = { "application/json", "application/xml" })
public class CrmController {

    private static final Logger LOG = LoggerFactory.getLogger(CrmController.class);
    // CustomerAccountObj
    @Autowired
    private CrmManager crmManager;

    @RequestMapping(value = "getCustomerAccounts", method = RequestMethod.GET)
    public CrmQueryResult getCustomerAccounts(String openUserId) {
        CrmQueryResult result = null;

        try {
            result = crmManager.getCustomerAccounts(openUserId);
        } catch (AccessTokenException e) {
            LOG.error("getCustomerAccounts access token error, details:", e);
            result = new CrmQueryResult();
            result.setErrorCode(e.getCode());
            result.setErrorMessage(e.getMessage());
        }

        return result;
    }

}
