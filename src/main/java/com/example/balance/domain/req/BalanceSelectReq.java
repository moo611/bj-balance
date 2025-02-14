package com.example.balance.domain.req;

import lombok.Data;

import java.io.Serializable;
@Data
public class BalanceSelectReq implements Serializable {

    int topN = 4;

    Float sizeX;

    Float sizeY;

    Float sizeZ;

    Float BalanceX;

    Float BalanceY;

    Float BalanceZ;

    Float BalanceMx;


    Float BalanceMy;

    Float BalanceMz;

}
