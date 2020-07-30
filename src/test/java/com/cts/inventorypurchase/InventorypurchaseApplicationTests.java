package com.cts.inventorypurchase;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.inventorypurchase.contoller.PurchaseController;
import com.cts.inventorypurchase.entities.Purchase;


@SpringBootTest
@RunWith(SpringRunner.class)

class InventorypurchaseApplicationTests {

	@Autowired
	PurchaseController controller;
	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate() {
		Purchase purchase = new Purchase();
		purchase.setId(3);
		purchase.setName("TV");
		purchase.setCount(1);
		purchase.setFinishedCount(1);;
		controller.addPurchase(purchase);
	}

	@Test
	public void testRead() {
		Purchase purchase = controller.findPurchase(3);
		/* System.out.println("TV:::::::::::"+ purchase.getName()); */
	}

	
	/*
	 * @Test public void testUpdate() { Purchase purchase =
	 * controller.findPurchase(3); if (purchase != null) { purchase.setCount(2);
	 * controller.updatePurchase(purchase); } }
	 */
	 
	
	@Test
	public void testDelete() {
		if (controller.findPurchase(3) != null) {
			System.out.println("Deleting the product");
			controller.deletePurchase(3);
		}
	}

}
