package com.example.demo.answer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.demo.mentee.q06_singlenabeatu.SingleNabeatuService;

class SingleNabeatuServiceTest {
	SingleNabeatuService singleNabeatuService = new SingleNabeatuService();

	/* 境界値 */
	@Test
	void 入力が0である() {
		/* データの準備 */
		int inputNumber = 0;

		/* テスト対象メソッド実行 */
		boolean actual = singleNabeatuService.isAhoNumber(inputNumber);

		/* 検証 */
		assertFalse(actual);
	}

	/* 境界値-1 */
	@Test
	void 入力がマイナス1である() {
		/* データの準備 */
		int inputNumber = -1;

		/* テスト対象メソッド実行 */
		boolean actual = singleNabeatuService.isAhoNumber(inputNumber);

		/* 検証 */
		assertFalse(actual);
	}

	/* 境界値+1 */
	@Test
	void 入力が1である() {
		/* データの準備 */
		int inputNumber = 1;

		/* テスト対象メソッド実行 */
		boolean actual = singleNabeatuService.isAhoNumber(inputNumber);

		/* 検証 */
		assertFalse(actual);
	}

	@Test
	void 入力が3を含む数字である_かつ_3の倍数ではない() {
		/* データの準備 */
		int inputNumber = 13;

		/* テスト対象メソッド実行 */
		boolean actual = singleNabeatuService.isAhoNumber(inputNumber);

		/* 検証 */
		assertTrue(actual);
	}

	@Test
	void 入力が3を含まない数字である_かつ_3の倍数である() {
		/* データの準備 */
		int inputNumber = 6;

		/* テスト対象メソッド実行 */
		boolean actual = singleNabeatuService.isAhoNumber(inputNumber);

		/* 検証 */
		assertTrue(actual);
	}

	@Test
	void 入力が0ではない_かつ_3を含まない数字である_かつ_3の倍数ではない() {
		/* データの準備 */
		int inputNumber = 11;

		/* テスト対象メソッド実行 */
		boolean actual = singleNabeatuService.isAhoNumber(inputNumber);

		/* 検証 */
		assertFalse(actual);
	}
}
