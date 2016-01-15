/**
 * @Title AJourBOImpl.java 
 * @Package com.ibis.account.bo.impl 
 * @Description 
 * @author miyb  
 * @date 2015-3-15 下午3:22:07 
 * @version V1.0   
 */
package com.std.account.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.account.bo.IAJourBO;
import com.std.account.bo.base.PaginableBOImpl;
import com.std.account.dao.IAJourDAO;
import com.std.account.domain.AccountJour;
import com.std.account.enums.EBoolean;

/** 
 * @author: miyb 
 * @since: 2015-3-15 下午3:22:07 
 * @history:
 */
@Component
public class AJourBOImpl extends PaginableBOImpl<AccountJour> implements
        IAJourBO {
    @Autowired
    private IAJourDAO aJourDAO;

    /** 
     * @see com.ibis.account.bo.IAJourBO#refreshCheckJour(java.lang.Long, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int refreshCheckJour(Long aJourNo, String checkUser,
            String checkResult, String remark) {
        int count = 0;
        if (aJourNo > 0 && StringUtils.isNotBlank(checkUser)) {
            EBoolean br = EBoolean.getBooleanResultMap().get(checkResult);
            if (br != null) {
                AccountJour data = new AccountJour();
                data.setAjNo(aJourNo);
                data.setCheckUser(checkUser);
                data.setCheckDatetime(new Date());
                data.setRemark(remark);
                count = aJourDAO.updateCheckInfo(data);
            }
        }
        return count;
    }

    /** 
     * @see com.ibis.account.bo.IAJourBO#getAccountJour(java.lang.Long)
     */
    @Override
    public AccountJour getAccountJour(Long ajNo) {
        AccountJour data = null;
        if (ajNo > 0) {
            AccountJour condition = new AccountJour();
            condition.setAjNo(ajNo);
            data = aJourDAO.select(condition);
        }
        return data;
    }

    /** 
     * @see com.ibis.account.bo.IAJourBO#queryAccountJourList(com.ibis.account.domain.AccountJour)
     */
    @Override
    public List<AccountJour> queryAccountJourList(AccountJour condition) {
        return aJourDAO.selectList(condition);
    }

}