package com.oracle.conversorMonedas;

public class Conversor {
    Request r = new Request();

    public double USDTo(double money,String c){
        return money * r.getCurrencyRequest(c);
    }
    public double ToUSD(double money,String c){
        return money/r.getCurrencyRequest(c);
    }
    public double COPToARS(double cop){
        return (cop/r.getCurrencyRequest("COP"))*r.getCurrencyRequest("ARS");
    }
}
