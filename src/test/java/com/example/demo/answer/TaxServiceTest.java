package com.example.demo.answer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.demo.mentee.q03_tax.TaxService;

class TaxServiceTest {
	TaxService taxService = new TaxService();
	
	@Test
	void 税込価格を計算() {
		assertEquals(220, taxService.getTaxCalcResult(200), 0.1);
	}

	@Test
	void 税率を取得() {
		assertEquals(0.1, taxService.getTaxRate());
	}
}
