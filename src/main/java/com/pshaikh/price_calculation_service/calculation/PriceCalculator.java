package com.pshaikh.price_calculation_service.calculation;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.pshaikh.price_calculation_service.web.Item;
import com.pshaikh.price_calculation_service.web.ItemPrice;

@Service
public class PriceCalculator {
	public ItemPrice calculate(Item item) {
		// when no discount set it to 1
		if (!(item.getPercentageDiscount() > 0)) {
			item.setPercentageDiscount(1);
		}
		// to provide proper values for this formula
		float price = item.getBasePrice() * item.getUnits() * (item.getPercentageDiscount() / 100);

		return new ItemPrice(item.getItemId(), item.getItemDescription(), item.getUnits(),
				roundToTwoDecimalDigits(price));
	}

	private float roundToTwoDecimalDigits(float number) {
		BigDecimal bd = new BigDecimal(Float.toString(number));
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		return bd.floatValue();
	}
}
