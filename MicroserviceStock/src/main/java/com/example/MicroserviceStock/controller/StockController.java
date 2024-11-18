package com.example.MicroserviceStock.controller;

import com.example.MicroserviceStock.bo.AccountResponse;
import com.example.MicroserviceStock.bo.CreateStockRequest;
import com.example.MicroserviceStock.bo.UpdateStockResponse;
import com.example.MicroserviceStock.service.StockService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping("/addItems")
    public void addItems(@RequestBody CreateStockRequest request) {
        stockService.addItems(request);
    }

    @PostMapping("/updateStock")
    public UpdateStockResponse updateStock(@RequestBody CreateStockRequest request) {
        return stockService.updateStock(request);
    }

    @GetMapping("/account")
    public AccountResponse getAccount() {
        return new AccountResponse(stockService.getStocks());
    }
}
