package com.example.MicroserviceStock.service;

import com.example.MicroserviceStock.bo.CreateStockRequest;
import com.example.MicroserviceStock.bo.UpdateStockResponse;
import com.example.MicroserviceStock.entity.StockEntity;
import com.example.MicroserviceStock.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public UpdateStockResponse updateStock(CreateStockRequest request) {
        System.out.println("Inside update inventory for order " + request);
        UpdateStockResponse orderStatus = new UpdateStockResponse();

        try {
            Iterable<StockEntity> inventories = stockRepository.findByItem(request.getItem());
            boolean exists = inventories.iterator().hasNext();

            if (!exists) {
                System.out.println("Stock doesn't exist, order will be reverted.");
                throw new Exception("Stock not available");
            }

            inventories.forEach(i -> {
                i.setQuantity(i.getQuantity() - request.getQuantity());
                stockRepository.save(i);
                orderStatus.setItem(i.getItem());
                orderStatus.setOrderId(i.getId());
                orderStatus.setRemainingQuantity(i.getQuantity());
                orderStatus.setStatus("Success");
            });
        } catch (Exception _) {
        }
        return orderStatus;
    }

    @Override
    public void addItems(CreateStockRequest stock) {
        Iterable<StockEntity> items = stockRepository.findByItem(stock.getItem());
        boolean exists = items.iterator().hasNext();
        if (!exists) {
            StockEntity i = new StockEntity();
            i.setItem(stock.getItem());
            i.setQuantity(stock.getQuantity());
            stockRepository.save(i);
        }
        items.forEach(i -> {
            i.setQuantity(i.getQuantity() + stock.getQuantity());
            stockRepository.save(i);
        });

    }

    @Override
    public List<StockEntity> getStocks() {
        return stockRepository.findAll();
    }
}
