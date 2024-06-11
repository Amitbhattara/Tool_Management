package com.rentatool;

import com.rentatool.service.ToolCheckoutService;

public class RentAToolApplication {

	public static void main(String[] args) throws Exception {
		ToolCheckoutService toolCheckoutService = new ToolCheckoutService();
		System.out.println(toolCheckoutService.toolCheckout("JAKD", "9/3/15", 6, "0%"));
		System.out.println(toolCheckoutService.toolCheckout("JAKR", "7/2/15", 9, "0%"));
		System.out.println(toolCheckoutService.toolCheckout("JAKR", "7/2/20", 4, "50%"));
		System.out.println(toolCheckoutService.toolCheckout("LADW", "7/2/20", 3, "10%"));
		System.out.println(toolCheckoutService.toolCheckout("CHNS", "7/2/15", 5, "25%"));
		System.out.println(toolCheckoutService.toolCheckout("JAKR", "9/3/15", 5, "101%"));
	}
}
