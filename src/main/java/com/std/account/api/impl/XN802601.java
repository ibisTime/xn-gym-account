package com.std.account.api.impl;

import com.std.account.ao.IOrderAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.dto.req.XN802601Req;
import com.std.account.dto.res.XN802601Res;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 审批线下充值订单
 * @author: myb858 
 * @since: 2015年8月26日 下午3:44:00 
 * @history:
 */
public class XN802601 extends AProcessor {
    private IOrderAO orderAO = SpringContextHolder.getBean(IOrderAO.class);

    private XN802601Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        orderAO.doApprove(req.getOrderType(), req.getOrderNo(),
            req.getApproveUser(), req.getApproveResult(), req.getRemark());
        return new XN802601Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802601Req.class);
        StringValidater.validateBlank(req.getOrderType(), req.getOrderNo(),
            req.getApproveUser(), req.getApproveResult(), req.getRemark());
    }
}