package com.example.MicroserviceStock.service;

import com.example.MicroserviceStock.bo.CreateStockRequest;
import com.example.MicroserviceStock.bo.UpdateStockResponse;
import com.example.MicroserviceStock.entity.StockEntity;

import java.util.List;

public interface StockService {
    UpdateStockResponse updateStock(CreateStockRequest request);
    void addItems(CreateStockRequest request);
    List<StockEntity> getStocks();
}
