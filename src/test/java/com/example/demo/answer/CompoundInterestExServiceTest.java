package com.example.demo.answer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.mentee.q11_compoundinterestex.CompoundInterestExService;

@ExtendWith(MockitoExtension.class)
class CompoundInterestExServiceTest {
	private CompoundInterestExService compoundInterestExService = new CompoundInterestExService();

	@Spy
	CompoundInterestExService mockCompoundInterestExService;

	@Test
	void 複利計算が正しくできる_リストに格納() {
		/* データの準備 */
		int principal = 100000;
		double rate = 0.1;
		int year = 3;

		List<Double> expectedPriceList = new ArrayList<>();
		expectedPriceList.add(100100.0);
		expectedPriceList.add(100200.0);
		expectedPriceList.add(100300.0);

		/* テスト対象メソッド実行 */
		List<Double> actualPriceList = compoundInterestExService.getPriceList(principal, rate, year);

		/* 検証 */
		for (int i = 0; i < year; i++) {
			assertEquals(expectedPriceList.get(i), actualPriceList.get(i), 0.5);
		}
	}

	@Test
	void 目標金額メッセージが正しく取得できる() {
		/* データの準備 */
		int year = 5;
		int targetPrice = 100500;
		int retValOfFailure = 0;
		String expectedSuccessMessage = Integer.toString(year) + "年目に達成！！！";
		String expectedFailureMessage = "目標金額には及ばず・・・";
		String actualMessage = null;

		/* 目標達成 振る舞い定義 検証 */
		doReturn(year).when(mockCompoundInterestExService).getOveredTargetPriceYear(anyList(), anyInt());
		actualMessage = mockCompoundInterestExService.getIsOveredYearMsg(new ArrayList<Double>(), targetPrice);
		assertEquals(expectedSuccessMessage, actualMessage);

		/* 目標未達成 振る舞い定義 検証 */
		doReturn(retValOfFailure).when(mockCompoundInterestExService).getOveredTargetPriceYear(anyList(), anyInt());
		actualMessage = mockCompoundInterestExService.getIsOveredYearMsg(new ArrayList<Double>(), targetPrice);
		assertEquals(expectedFailureMessage, actualMessage);
	}

	@Test
	void 目標金額に到達した年数が取得できる() {
		/* データの準備 */
		List<Double> priceList = new ArrayList<>();
		priceList.add(100100.0);
		priceList.add(100200.0);
		priceList.add(100300.0);
		priceList.add(100401.0);
		priceList.add(100501.0);
		priceList.add(100602.0);
		priceList.add(100702.0);
		int targetPriceOfSuccess = 100550;
		int expectedYearOfSuccess = 6;
		int targetPriceOfFailure = 200000;
		int expectedRetValOfFailure = 0;
		int actualYear = 0;

		/* 達成 テスト対象メソッド実行 検証 */
		actualYear = compoundInterestExService.getOveredTargetPriceYear(
				priceList,
				targetPriceOfSuccess
		);
		assertEquals(expectedYearOfSuccess, actualYear);

		/* 未達成 テスト対象メソッド実行 検証 */
		actualYear = compoundInterestExService.getOveredTargetPriceYear(
				priceList,
				targetPriceOfFailure
		);
		assertEquals(expectedRetValOfFailure, actualYear);
	}
}
