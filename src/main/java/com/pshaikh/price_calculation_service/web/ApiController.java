package com.pshaikh.price_calculation_service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pshaikh.price_calculation_service.calculation.PriceCalculator;

@RestController
public class ApiController {
	@Autowired
	PriceCalculator pc;
	
	@RequestMapping("/calculate")
	public List<ItemPrice> calculatePrice(@RequestBody List<Item> itemlist) {
		//TODO implementation
		return null;
	}
}
