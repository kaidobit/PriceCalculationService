package com.pshaikh.price_calculation_service.calculation;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.pshaikh.price_calculation_service.web.Item;
import com.pshaikh.price_calculation_service.web.ItemPrice;

@Service
public class PriceCalculator {
	public ItemPrice calculate(Item item) {
		float price = 0f;

		// when no units are set, provide defaultvalue = 1
		if (item.getUnits() < 1) {
			item.setUnits(1);
		}

		price = item.getBasePrice() * item.getUnits();
		// only consider discounts when discount is set 
		if (item.getPercentageDiscount() > 0) {
				price -= (item.getPercentageDiscount() / 100);
		}

		return new ItemPrice(item.getItemId(), item.getItemDescription(), item.getUnits(),
				roundToTwoDecimalDigits(price));
	}

	private float roundToTwoDecimalDigits(float number) {
		BigDecimal bd = new BigDecimal(Float.toString(number));
		//round to two decimal digits
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		return bd.floatValue();
	}
}
