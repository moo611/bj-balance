package com.example.balance.domain.req;

import com.example.balance.domain.base.BaseReq;
import lombok.Data;

@Data
public class BalanceSupportListReq extends BaseReq {

    String balanceCode;
}
