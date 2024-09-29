package com.example.demo.answer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.demo.mentee.q02_bmi.BmiService;

class BmiServiceTest {

	@Test
	void BMIが正しく計算される() {
		BmiService bmiService = new BmiService();

		/* データの準備 */
		double mHeight = 1.75;
		double kgWeight = 72.0;
		double delta = 0.1;        // 誤差の範囲(double型の検証のため、許容誤差が必要)
		double expectedBmi = 23.5; // 期待値

		/* テスト対象メソッド実行 */
		double actualBmi = bmiService.getBmiCalcResult(mHeight, kgWeight);

		/* 検証 */
		assertEquals(expectedBmi, actualBmi, delta);
	}
}
