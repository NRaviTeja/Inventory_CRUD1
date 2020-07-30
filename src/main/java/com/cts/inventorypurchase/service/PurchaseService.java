package com.cts.inventorypurchase.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.stereotype.Service;

import com.cts.inventorypurchase.entities.Purchase;
import com.cts.inventorypurchase.repos.PurchaseRepository;



@Service

public class PurchaseService {
	Logger log = LoggerFactory.getLogger(PurchaseService.class);
	

	@Autowired
	private PurchaseRepository repository;
	
	

	public Purchase savePurchase(Purchase purchase) {
		log.info("inserting the purchase Object from service");
		return repository.save(purchase);
	}

	public List<Purchase> savePurchase(List<Purchase> purchases) {
		log.info("inserting multiple purchase Object from service");
		return (List<Purchase>) repository.saveAll(purchases);
	}

	public List<Purchase> getPurchases() {
		log.info("Getting the purchase Object from service");
		return (List<Purchase>) repository.findAll();
	}

	 @Cacheable(cacheNames = "purchase", key = "#id")
	public Purchase getPurchaseById(int id) {
		Optional<Purchase> purchase= repository.findById(id);
		log.info("Getting the specific purchase Object from service");
		if(purchase.isPresent())
		{
			return purchase.get();
		}
		else {
		return new Purchase();
		}
	}
	 @CacheEvict(cacheNames = "purchase", key = "#id")
	public String deletePurchase(int id) {
		repository.deleteById(id);
		log.info("Deleted the specific purchase Object from service");
		return "puchase removed ||" + id;
	}

	 @CachePut(cacheNames = "purchase", key = "#purchase.id")
	public Purchase updatePurchase(Purchase purchase) {
		Purchase existingPurchase = repository.findById(purchase.getId()).orElse(null);
		existingPurchase.setName(purchase.getName());
		existingPurchase.setCount(purchase.getCount());
		existingPurchase.setFinishedCount(purchase.getFinishedCount());		
		log.info("Updating  the specific purchase Object from service");
		return repository.save(existingPurchase);
		
		
	}

}
