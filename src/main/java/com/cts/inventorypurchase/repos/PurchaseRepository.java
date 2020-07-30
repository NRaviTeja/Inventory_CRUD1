package com.cts.inventorypurchase.repos;

import org.springframework.data.repository.CrudRepository;

import com.cts.inventorypurchase.entities.Purchase;

public interface PurchaseRepository extends CrudRepository<Purchase, Integer> {



}
