package com.pshaikh.price_calculation_service.web;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	@RequestMapping("/calculate")
	public ItemPrice calculatePrice(@RequestBody List<Item> itemlist) {
		//TODO implementation
		return null;
	}
}
