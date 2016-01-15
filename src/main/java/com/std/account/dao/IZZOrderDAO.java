/**
 * @Title ITransferJourDAO.java 
 * @Package com.ibis.account.dao 
 * @Description 
 * @author miyb  
 * @date 2015-2-14 下午2:10:14 
 * @version V1.0   
 */
package com.std.account.dao;

import java.util.List;

import com.std.account.dao.base.IBaseDAO;
import com.std.account.domain.ZZOrder;

/** 
 * @author: miyb 
 * @since: 2015-2-14 下午2:10:14 
 * @history:
 */
public interface IZZOrderDAO extends IBaseDAO<ZZOrder> {
    String NAMESPACE = IZZOrderDAO.class.getName().concat(".");

    /**
     * 统计信息
     * @param condition
     * @return 
     * @create: 2015年10月27日 上午11:39:23 myb858
     * @history:
     */
    List<ZZOrder> doStatisticsDvalue(ZZOrder condition);
}