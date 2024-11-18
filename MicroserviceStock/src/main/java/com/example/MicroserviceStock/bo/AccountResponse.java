package com.example.MicroserviceStock.bo;

import com.example.MicroserviceStock.entity.StockEntity;
import java.util.List;

public class AccountResponse {
    private List<StockEntity> stocks;

    public AccountResponse(List<StockEntity> stocks) {
        this.stocks = stocks;
    }

    public List<StockEntity> getStocks() {
        return stocks;
    }

    public void setStocks(List<StockEntity> stocks) {
        this.stocks = stocks;
    }
}
