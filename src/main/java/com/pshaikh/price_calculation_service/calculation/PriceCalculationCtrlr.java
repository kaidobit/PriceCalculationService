package com.pshaikh.price_calculation_service.calculation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pshaikh.price_calculation_service.web.Item;
import com.pshaikh.price_calculation_service.web.ItemPrice;

@Controller
public class PriceCalculationCtrlr {
	@Autowired
	PriceCalculator pc;
	
	public List<ItemPrice> calculate(List<Item> itemlist) {
		List<ItemPrice> itemPrices = new ArrayList<>();

		// add each itemprice to response list
		for (Item item : itemlist) {
			itemPrices.add(pc.calculate(item));
		}

		return itemPrices;
	}
}
