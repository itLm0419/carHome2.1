package com.carhome.test;

import org.junit.Test;

import com.carhome.action.ShoppingCarAction;

public class TestShoppingCar {
	@Test
	public void testClearUpCar(){
		ShoppingCarAction shoppingCarAction = new ShoppingCarAction();
		shoppingCarAction.clearUpCar();
	}
}
