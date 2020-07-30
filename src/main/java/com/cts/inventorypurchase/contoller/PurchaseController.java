package com.cts.inventorypurchase.contoller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.inventorypurchase.entities.Purchase;
import com.cts.inventorypurchase.service.PurchaseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController

@Api(value = "CRUD Operation for Purchase items", description = "shows CRUD operation on purchase items")
public class PurchaseController {
	Logger log = LoggerFactory.getLogger(PurchaseController.class);

	@Autowired
	private PurchaseService service;

	@ApiOperation(value = "you can add one purchase iteam")
	@PostMapping("/inventory/addPurchase")
	public Purchase addPurchase(@RequestBody Purchase purchase) {
		log.info("Adding one purchase from controller");
		return service.savePurchase(purchase);
	}

	@ApiOperation(value = "you can add multiple purchase iteams")
	@PostMapping("/inventory/addPurchases")
	public List<Purchase> addPurchases(@RequestBody List<Purchase> purchases) {
		log.info("Adding multiple purchase from controller");
		return service.savePurchase(purchases);
	}

	@ApiOperation(value = "you can get multiple purchase iteams")
	@GetMapping("/inventory/Purchase")
	public List<Purchase> fidAllPurchase() {
		log.info("Getting multiple purchase from controller");
		return service.getPurchases();
	}

	@ApiOperation(value = "you can get one purchase iteam")
	@GetMapping("/inventory/Purchase/{id}")
	public Purchase findPurchase(@PathVariable int id) {
		log.info("Getting Particular purchase from controller");
		return service.getPurchaseById(id);
	}

	@ApiOperation(value = "you can update the purchase iteam")
	@PutMapping("/inventory/updatePurchase")
	public Purchase updatePurchase(@RequestBody Purchase purchase) {
		log.info("Updating  purchase from controller");
		return service.updatePurchase(purchase);
	}

	@ApiOperation(value = "you can delete one purchase iteam")
	@DeleteMapping("/inventory/Purchase/{id}")
	public String deletePurchase(@PathVariable int id) {
		log.info("Dele multiple purchase from controller");
		return service.deletePurchase(id);
	}
}
