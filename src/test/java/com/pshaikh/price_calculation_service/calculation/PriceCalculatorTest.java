package com.pshaikh.price_calculation_service.calculation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pshaikh.price_calculation_service.web.Item;

public class PriceCalculatorTest {
	private PriceCalculator underTest = new PriceCalculator();
	private Item item;

	private final int ITEM_ID = 1;
	private final String ITEM_DESCRIPTION = "";
	private final float BASE_PRICE = 1.189f;
	private final int ZERO_UNITS = 0;
	private final int FOUR_UNITS = 4;
	private final float NO_DISCOUNT = 0f; // when no discount provided in request, it defaults to 0
	private final float DISCOUNT = 20f;
	private float percentageDiscount;
	private int units;

	private float endprice;
	private final float NO_DISCOUNT_ZERO_UNITS_PRICE = 1.19f;
	private final float NO_DISCOUNT_FOUR_UNITS_PRICE = 4.76f;
	private final float DISCOUNT_ZERO_UNITS_PRICE = 0.95f;
	private final float DISCOUNT_FOUR_UNITS_PRICE = 3.8f;
	private final int AMOUNT_DECIMAL_DIGITS_AFTER_ROUNDING = 2;

	@Test
	public void testCalculationWithZeroUnitsAndWithoutDiscount() {
		given().zeroUnits().noDiscountProvided();

		when().itemIsCreated().priceIsCalculated();

		than().endpriceEqualsNoDiscountZeroUnitsPrice().endpriceHasOnlyTwoDecimalDigits();
	}

	@Test
	public void testCalculationWithFourUnitsAndWithoutDiscount() {
		given().fourUnits().noDiscountProvided();

		when().itemIsCreated().priceIsCalculated();

		than().endpriceEqualsNoDiscountFourUnitsPrice().endpriceHasOnlyTwoDecimalDigits();
	}

	@Test
	public void testCalculationWithZeroUnitsAndWithDiscount() {
		given().zeroUnits().discountProvided();

		when().itemIsCreated().priceIsCalculated();

		than().endpriceEqualsDiscountZeroUnitsPrice().endpriceHasOnlyTwoDecimalDigits();
	}

	@Test
	public void testCalculationWithFourUnitsAndWithDiscount() {
		given().fourUnits().discountProvided();

		when().itemIsCreated().priceIsCalculated();

		than().endpriceEqualsDiscountFourUnitsPrice().endpriceHasOnlyTwoDecimalDigits();
	}

	private PriceCalculatorTest given() {
		return this;
	}

	private PriceCalculatorTest zeroUnits() {
		units = ZERO_UNITS;
		return this;
	}

	private PriceCalculatorTest fourUnits() {
		units = FOUR_UNITS;
		return this;
	}

	private PriceCalculatorTest noDiscountProvided() {
		percentageDiscount = NO_DISCOUNT;
		return this;
	}

	private PriceCalculatorTest discountProvided() {
		percentageDiscount = DISCOUNT;
		return this;
	}

	private PriceCalculatorTest when() {
		return this;
	}

	private PriceCalculatorTest itemIsCreated() {
		item = new Item(BASE_PRICE, ITEM_DESCRIPTION, units, percentageDiscount, ITEM_ID);
		return this;
	}

	private PriceCalculatorTest priceIsCalculated() {
		endprice = underTest.calculate(item).getPrice();
		return this;
	}

	private PriceCalculatorTest than() {
		return this;
	}

	private PriceCalculatorTest endpriceEqualsNoDiscountZeroUnitsPrice() {
		assertTrue(endprice == NO_DISCOUNT_ZERO_UNITS_PRICE);
		return this;
	}

	private PriceCalculatorTest endpriceHasOnlyTwoDecimalDigits() {
		String decimalDigits = String.valueOf(endprice).split("\\.")[1];
		assertTrue(decimalDigits.length() <= AMOUNT_DECIMAL_DIGITS_AFTER_ROUNDING);
		return this;
	}

	private PriceCalculatorTest endpriceEqualsNoDiscountFourUnitsPrice() {
		assertTrue(endprice == NO_DISCOUNT_FOUR_UNITS_PRICE);
		return this;
	}

	private PriceCalculatorTest endpriceEqualsDiscountZeroUnitsPrice() {
		assertTrue(endprice == DISCOUNT_ZERO_UNITS_PRICE);
		return this;
	}

	private PriceCalculatorTest endpriceEqualsDiscountFourUnitsPrice() {
		assertTrue(endprice == DISCOUNT_FOUR_UNITS_PRICE);
		return this;
	}

}
