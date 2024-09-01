package com.example.demo.mentor.q03_tax;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class TaxFormModel {

	// 税抜き金額
	@NotNull
	@Min(1)
	private int priceWithoutTax;

}
