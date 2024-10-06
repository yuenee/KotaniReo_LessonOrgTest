package com.example.demo.answer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.example.demo.mentee.q10_calculator.CalculatorService;

class CalculatorServiceTest {
	CalculatorService calculatorService = new CalculatorService();

	@Test
	void 演算子の配列が取得できる() {
		/* データの準備 */
		String[] expectedCalcTypeNameArray = {"足し算", "引き算", "掛け算", "割り算"};

		/* テスト対象メソッド実行 */
		String[] actualCalcTypeNameArray = calculatorService.getCalcTypeNameArray();

		/* 検証 */
		assertArrayEquals(expectedCalcTypeNameArray, actualCalcTypeNameArray);
	}

	@Test
	void 演算子のマップが取得できる() {
		/* データの準備 */
		Map<String, String> expectedCalcTypes = new LinkedHashMap<String, String>();
		expectedCalcTypes.put("add", "+");
		expectedCalcTypes.put("sub", "-");
		expectedCalcTypes.put("mul", "×");
		expectedCalcTypes.put("div", "÷");

		/* テスト対象メソッド実行 */
		Map<String, String> actualCalcTypes = calculatorService.getCalcTypes();

		assertEquals(expectedCalcTypes, actualCalcTypes);
	}

	@Test
	void 英名演算子を和名演算子に変換できる() {
		/* データの準備 */
		final String EXPECTED_ADD = "足し算";
		final String EXPECTED_SUB = "引き算";
		final String EXPECTED_MUL = "掛け算";
		final String EXPECTED_DIV = "割り算";
		String actualOperator = null;

		/* 足し算検証 */
		actualOperator = calculatorService.convertPysicalCalcType("add");
		assertEquals(EXPECTED_ADD, actualOperator);

		/* 引き算検証 */
		actualOperator = calculatorService.convertPysicalCalcType("sub");
		assertEquals(EXPECTED_SUB, actualOperator);

		/* 掛け算検証 */
		actualOperator = calculatorService.convertPysicalCalcType("mul");
		assertEquals(EXPECTED_MUL, actualOperator);

		/* 割り算検証 */
		actualOperator = calculatorService.convertPysicalCalcType("div");
		assertEquals(EXPECTED_DIV, actualOperator);
	}

	@Test
	void 各演算子で正しく計算ができる() {
		/* データの準備 */
		final double num1 = 8.0;
		final double num2 = 0.125;
		final String ADD = "add";
		final String SUB = "sub";
		final String MUL = "mul";
		final String DIV = "div";
		final double EXPECTED_ADD_ANSWER = 8.125;
		final double EXPECTED_SUB_ANSWER = 7.875;
		final double EXPECTED_MUL_ANSWER = 1.0;
		final double EXPECTED_DIV_ANSWER = 64.0;
		double actualAnswer = 0.0;

		/* 足し算検証 */
		actualAnswer = calculatorService.calculate(ADD, num1, num2);
		assertEquals(EXPECTED_ADD_ANSWER, actualAnswer);

		/* 引き算検証 */
		actualAnswer = calculatorService.calculate(SUB, num1, num2);
		assertEquals(EXPECTED_SUB_ANSWER, actualAnswer);

		/* 掛け算検証 */
		actualAnswer = calculatorService.calculate(MUL, num1, num2);
		assertEquals(EXPECTED_MUL_ANSWER, actualAnswer);

		/* 割り算検証 */
		actualAnswer = calculatorService.calculate(DIV, num1, num2);
		assertEquals(EXPECTED_DIV_ANSWER, actualAnswer);
	}

	@Test
	void 正しく足し算が計算できる() {
		/* データの準備 */
		final double NUM1 = 5.7;
		final double NUM2 = 0.3;
		final double EXPECTED_ANSWER = 6.0;

		/* テスト対象メソッド実行 */
		double actualAnswer = calculatorService.add(NUM1, NUM2);

		/* 検証 */
		assertEquals(EXPECTED_ANSWER, actualAnswer);
	}

	@Test
	void 正しく引き算が計算できる() {
		/* データの準備 */
		final double NUM1 = 5.7;
		final double NUM2 = 0.3;
		final double EXPECTED_ANSWER = 5.4;

		/* テスト対象メソッド実行 */
		double actualAnswer = calculatorService.sub(NUM1, NUM2);

		/* 検証 */
		assertEquals(EXPECTED_ANSWER, actualAnswer);	
	}

	@Test
	void 正しく掛け算が計算できる() {
		/* データの準備 */
		final double NUM1 = 5.7;
		final double NUM2 = 0.3;
		final double EXPECTED_ANSWER = 1.71;

		/* テスト対象メソッド実行 */
		double actualAnswer = calculatorService.mul(NUM1, NUM2);

		/* 検証 */
		assertEquals(EXPECTED_ANSWER, actualAnswer);	
	}

	@Test
	void 正しく割り算が計算できる() {
		/* データの準備 */
		final double NUM1 = 5.7;
		final double NUM2 = 0.3;
		final double EXPECTED_ANSWER = 19.0;

		/* テスト対象メソッド実行 */
		double actualAnswer = calculatorService.div(NUM1, NUM2);

		/* 検証 */
		assertEquals(EXPECTED_ANSWER, actualAnswer);	
	}

}
