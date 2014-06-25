package com.practicaljava.lesson34;

import javax.xml.bind.annotation.XmlRootElement;
import javax.json.*;

@XmlRootElement
//@JsonRootElement
public class Stock {
    private String symbol;
    private String price;
    private String currency;
    private String country;

    public Stock() {
    }

    public Stock(String symbol,String price, String currency, String country) {
        this.symbol = symbol;
        this.price = price;
        this.currency = currency;
        this.country = country;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}