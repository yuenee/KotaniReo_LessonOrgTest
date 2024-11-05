package com.example.demo.answer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.demo.mentee.q03_tax.TaxService;

class TaxServiceTest {
	TaxService taxService = new TaxService();

	@Test
	void 税込価格を計算() {
		/* データの準備 */
		int priceWithoutTax = 200;
		int expectedPrice = 220;

		/* テスト対象メソッド実行 */
		int actualPrice = (int)taxService.getTaxCalcResult(priceWithoutTax); // 金額の計算なので、int型にキャスト

		/* 検証 */
		assertEquals(expectedPrice, actualPrice);
	}

	@Test
	void 税率を取得() {
		/* データの準備 */
		double expectedTaxRate = 0.1;

		/* テスト対象メソッド実行 */
		double actualTaxRate = taxService.getTaxRate();

		/* 検証 */
		assertEquals(expectedTaxRate, actualTaxRate); // 定数の比較なので誤差は必要なし
	}
}
