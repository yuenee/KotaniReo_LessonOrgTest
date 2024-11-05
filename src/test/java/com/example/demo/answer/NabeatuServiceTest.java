package com.example.demo.answer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.mentee.q08_nabeatu.NabeatuService;

@ExtendWith(MockitoExtension.class)
class NabeatuServiceTest {
	@Spy
	NabeatuService nabeatuService = new NabeatuService();

	@Test
	void _1から入力値まで総和の計算() {
		/* データの準備 */
		int inputNumber = 100;
		int expectedSum = 5050;

		/* テスト対象メソッドの実行 */
		int actualSum = nabeatuService.getTotalNum(inputNumber);

		/* 検証 */
		assertEquals(expectedSum, actualSum);
	}

	/* 境界値 */
	@Test
	void 総和が0である() {
		/* getTotalNumメソッドの振る舞いを定義 */
		doReturn(0).when(nabeatuService).getTotalNum(anyInt());
		int total = nabeatuService.getTotalNum(0);

		/* テスト対象メソッド実行 */
		boolean actual = nabeatuService.isAhoNumber(total);

		/* 検証 */
		assertFalse(actual);
	}

	/* 境界値-1(1から入力値までの総和なので本来なら負の数はありえないが、境界値テストとして一応実施) */
	@Test
	void 総和がマイナス1である() {
		/* getTotalNumメソッドの振る舞いを定義 */
		doReturn(-1).when(nabeatuService).getTotalNum(anyInt());
		int total = nabeatuService.getTotalNum(0);

		/* テスト対象メソッド実行 */
		boolean actual = nabeatuService.isAhoNumber(total);

		/* 検証 */
		assertFalse(actual);
	}

	/* 境界値+1 */
	@Test
	void 総和が1である() {
		/* getTotalNumメソッドの振る舞いを定義 */
		doReturn(1).when(nabeatuService).getTotalNum(anyInt());
		int total = nabeatuService.getTotalNum(0);

		/* テスト対象メソッド実行 */
		boolean actual = nabeatuService.isAhoNumber(total);

		/* 検証 */
		assertFalse(actual);
	}

	@Test
	void 総和が数字3を含む_かつ_3の倍数ではない() {
		/* getTotalNumメソッドの振る舞いを定義 */
		doReturn(13).when(nabeatuService).getTotalNum(anyInt());
		int total = nabeatuService.getTotalNum(0);

		/* テスト対象メソッド実行 */
		boolean actual = nabeatuService.isAhoNumber(total);

		/* 検証 */
		assertTrue(actual);
	}

	@Test
	void 総和が数字3を含まない_かつ_3の倍数である() {
		/* getTotalNumメソッドの振る舞いを定義 */
		doReturn(9).when(nabeatuService).getTotalNum(anyInt());
		int total = nabeatuService.getTotalNum(0);

		/* テスト対象メソッド実行 */
		boolean actual = nabeatuService.isAhoNumber(total);

		/* 検証 */
		assertTrue(actual);
	}

	@Test
	void 総和が0ではない_かつ_総和が数字3を含まない_かつ_3の倍数ではない() {
		/* getTotalNumメソッドの振る舞いを定義 */
		doReturn(11).when(nabeatuService).getTotalNum(anyInt());
		int total = nabeatuService.getTotalNum(0);

		/* テスト対象メソッド実行 */
		boolean actual = nabeatuService.isAhoNumber(total);

		/* 検証 */
		assertFalse(actual);
	}
}
