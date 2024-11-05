package com.example.demo.answer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.demo.mentee.q09_compoundinterest.CompoundInterestService;

class CompoundInterestServiceTest {

	@Test
	void 正しく複利計算ができる() {
		CompoundInterestService compoundInterestService = new CompoundInterestService();

		/* データの準備 */
		int principal = 100000;
		double rate = 0.1;
		int year = 3;
		/* year年後の複利計算結果をx_year(0年後でprincipalであることに注意)とすると
		 *     x_year = principal * ((rate + 100) / 100)^(year)
		 * という式で表される( 初項(0項目) principal, 公比 ((rate + 100) / 100) の等比数列 )
		 */
		int expected = 100300; // 金額の計算なので小数点以下切り捨てで計算比較

		/* テスト対象メソッド実行 */
		int actual = (int)compoundInterestService.getResult(principal, rate, year); // 金額の計算なので、int型に変換

		/* 検証 */
		assertEquals(expected, actual);
	}
}
