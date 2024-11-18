package com.example.MicroserviceStock.repository;

import com.example.MicroserviceStock.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<StockEntity, Long> {
    Iterable<StockEntity> findByItem(String item);
    List<StockEntity> findAll();
}
