package com.rentatool.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.rentatool.model.ToolRentalCheckout;
import com.rentatool.service.ToolCheckoutService;

public class RentAToolApplicationTest {
	
	public RentAToolApplicationTest() {
	}
	
	private ToolCheckoutService toolCheckoutService = new ToolCheckoutService();
	
	@Test
	public void test1() {
		assertNull(toolCheckoutService.toolCheckout("JAKR", "9/3/15", 5, "101%"));
	}
	
	@Test
	public void test2() {
		ToolRentalCheckout checkout = toolCheckoutService.toolCheckout("LADW", "7/2/20", 3, "10%");
		assertNotNull(checkout);
		assertEquals("$5.37", checkout.getFinalCharge());
	}
	
	@Test
	public void test3() {
		ToolRentalCheckout checkout = toolCheckoutService.toolCheckout("CHNS", "7/2/15", 5, "25%");
		assertNotNull(checkout);
		assertEquals("$2.23", checkout.getFinalCharge());
	}
	
	@Test
	public void test4() {
		ToolRentalCheckout checkout = toolCheckoutService.toolCheckout("JAKD", "9/3/15", 6, "0%");
		assertNotNull(checkout);
		assertEquals("$11.96", checkout.getFinalCharge());
	}
	
	@Test
	public void test5() {
		ToolRentalCheckout checkout = toolCheckoutService.toolCheckout("JAKR", "7/2/15", 9, "0%");
		assertNotNull(checkout);
		assertEquals("$17.94", checkout.getFinalCharge());
	}
	
	@Test
	public void test6() {
		ToolRentalCheckout checkout = toolCheckoutService.toolCheckout("JAKR", "7/2/20", 4, "50%");
		assertNotNull(checkout);
		assertEquals("$1.50", checkout.getFinalCharge());
	}
}
