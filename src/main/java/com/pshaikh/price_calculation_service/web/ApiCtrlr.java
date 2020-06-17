package com.pshaikh.price_calculation_service.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pshaikh.price_calculation_service.calculation.PriceCalculator;

@RestController
public class ApiCtrlr {
	@Autowired
	PriceCalculator pc;

	@RequestMapping("/calculate")
	public List<ItemPrice> calculatePrice(@RequestBody List<Item> itemlist) {
		List<ItemPrice> response = new ArrayList<>();

		// add each itemprice to response list
		for (Item i : itemlist) {
			response.add(pc.calculate(i));
		}

		return response;
	}
}
