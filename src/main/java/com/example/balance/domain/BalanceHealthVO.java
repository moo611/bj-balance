package com.example.balance.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BalanceHealthVO implements Serializable {
    //天平code
    String balanceCode;
    //天平代号
    String balanceName;
    //参试历史
    String history;
    //综合评价
    String evaluation;

    //当前状态
    String balanceState;
    //健康状态
    String healthState;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date createTime;
}
