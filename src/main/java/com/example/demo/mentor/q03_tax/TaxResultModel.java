package com.example.demo.mentor.q03_tax;

import lombok.Data;

@Data
public class TaxResultModel {

	// 計算時税率
	private double taxRate;

	// 税込金額
	private double priceWithTax;
}
