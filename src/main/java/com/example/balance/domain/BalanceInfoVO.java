package com.example.balance.domain;

import lombok.Data;

@Data
public class BalanceInfoVO extends BalanceInfo{

    Float sizeX;

    Float sizeY;

    Float sizeZ;

    Float weightX = 1f, weightY = 1f, weightZ = 1f, weightMx = 1f, weightMy = 1f, weightMz = 1f,weightSizeX = 2f, weightSizeY = 2f, weightSizeZ = 2f;


    public double getWeightedMatchScore(Float targetX, Float targetY, Float targetZ,
                                        Float targetMx, Float targetMy, Float targetMz, Float sizeX, Float sizeY, Float sizeZ) {

        // 每个量程差值的平方乘以权重
        return Math.sqrt(
                weightX * Math.pow(getBalanceX() - targetX, 2) +
                        weightY * Math.pow(getBalanceY() - targetY, 2) +
                        weightZ * Math.pow(getBalanceZ() - targetZ, 2) +
                        weightMx * Math.pow(getBalanceMx() - targetMx, 2) +
                        weightMy * Math.pow(getBalanceMy() - targetMy, 2) +
                        weightMz * Math.pow(getBalanceMz() - targetMz, 2) +
                        weightSizeX * Math.pow(getSizeX()-sizeX,2)+
                        weightSizeY * Math.pow(getSizeY()-sizeY,2)+
                        weightSizeZ * Math.pow(getSizeZ()-sizeZ,2)
        );

    }

}
