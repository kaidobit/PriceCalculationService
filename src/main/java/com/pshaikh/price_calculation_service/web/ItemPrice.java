package com.pshaikh.price_calculation_service.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ItemPrice {
	@Getter
	@Setter
	private int itemId;
	@Getter
	@Setter
	private String itemDescription;
	@Getter
	@Setter
	private int units;
	@Getter
	@Setter
	private float price;
}
