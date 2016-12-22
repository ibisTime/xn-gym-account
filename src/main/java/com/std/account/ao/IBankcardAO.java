package com.std.account.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.std.account.bo.base.Paginable;
import com.std.account.domain.BankCard;

/**
 * 
 * @author: asus 
 * @since: 2016年12月22日 下午3:29:32 
 * @history:
 */
@Component
public interface IBankcardAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addBankcard(BankCard data);

    public int dropBankcard(String code);

    public int editBankcard(BankCard data);

    public Paginable<BankCard> queryBankcardPage(int start, int limit,
            BankCard condition);

    public List<BankCard> queryBankcardList(BankCard condition);

    public BankCard getBankcard(String code);

}
