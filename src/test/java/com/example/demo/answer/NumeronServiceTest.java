package com.example.demo.answer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedConstruction;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.mentee.q12_numeron.NumeronService;

@ExtendWith(MockitoExtension.class)
class NumeronServiceTest {
	@Spy
	NumeronService numeronService;

	@Test
	void ランダム数値3桁の答えの数列が格納されているリストが取得できる() {
		/* データの準備 */
		List<Integer> expectedIntList = new ArrayList<>();
		expectedIntList.add(0); expectedIntList.add(1); expectedIntList.add(2);

		/* initメソッド内部で呼ばれているRandomクラスの振る舞い定義 */
		try (MockedConstruction<Random> ignore = mockConstruction(
				Random.class,
				(mock, ctx) -> doReturn(0).when(mock).nextInt(anyInt()))) {
			List<Integer> actualIntList = numeronService.init();

			/* 検証 */
			assertEquals(expectedIntList, actualIntList);
		}
	}

	@ParameterizedTest
	@CsvSource({
		"0, 0",
		"0, 1",
		"0, 2",
		"1, 0",
		"1, 1",
		"1, 2",
		"2, 0",
		"2, 1",
		"2, 2"
	})
	void 合致判定結果が格納されているのリストが取得できる(int hitCount, int blowCount) {
		/* データの準備 */
		List<Integer> expectedAttackResult = new ArrayList<>();
		List<Integer> actualAttackResult = new ArrayList<>();
		String attackNumber = "000";

		/* 全パターン検証 */
		doReturn(hitCount).when(numeronService).getHitCount(anyList(), anyList());
		doReturn(blowCount).when(numeronService).getBlowCount(anyList(), anyList());
		expectedAttackResult.add(hitCount); expectedAttackResult.add(blowCount);
		actualAttackResult = numeronService.getAttackResult(new ArrayList<Integer>(), attackNumber);
		assertEquals(expectedAttackResult, actualAttackResult);
		expectedAttackResult.clear();
	}

	@Nested
	class 数値位置がともに合致_数字の個数が取得できる {
		/* データの準備 */
		private List<Integer> answerList = new ArrayList<>();
		private List<Integer> attackList = new ArrayList<>();
		private int expectedHitCount = 0;
		private int actualHitCount = 0;

		/* イニシャライザ */
		{
			answerList.add(0);
			answerList.add(1);
			answerList.add(2);
		}

		@Test
		@DisplayName("全て異なる")
		void 全て異なる() {
			expectedHitCount = 0;
			attackList.add(9); attackList.add(9); attackList.add(9);
			actualHitCount = numeronService.getHitCount(answerList, attackList);
			assertEquals(expectedHitCount, actualHitCount);
			attackList.clear();
		}

		@ParameterizedTest
		@CsvSource({
			"0, 0, 0",
			"1, 1, 1",
			"2, 2, 2"
		})
		@DisplayName("1箇所完全一致")
		void _1箇所完全一致(int num1, int num2, int num3) {
			expectedHitCount = 1;

			attackList.add(num1); attackList.add(num2); attackList.add(num3);
			actualHitCount = numeronService.getHitCount(answerList, attackList);
			assertEquals(expectedHitCount, actualHitCount);
			attackList.clear();
		}

		@ParameterizedTest
		@CsvSource({
			"9, 1, 2",
			"0, 9, 2",
			"0, 1, 9"
		})
		@DisplayName("2箇所完全一致")
		void _2箇所完全一致(int num1, int num2, int num3) {
			expectedHitCount = 2;

			attackList.add(num1); attackList.add(num2); attackList.add(num3);
			actualHitCount = numeronService.getHitCount(answerList, attackList);
			assertEquals(expectedHitCount, actualHitCount);
			attackList.clear();
		}

		@ParameterizedTest
		@CsvSource({
			"0, 1, 2"
		})
		@DisplayName("3箇所完全一致")
		void _3箇所完全一致(int num1, int num2, int num3) {
			expectedHitCount = 3;

			attackList.add(num1); attackList.add(num2); attackList.add(num3);
			actualHitCount = numeronService.getHitCount(answerList, attackList);
			assertEquals(expectedHitCount, actualHitCount);
			attackList.clear();
		}
	}

	@Nested
	class 数値は合致_位置は異なる_数字の個数が取得できる {
		/* データの準備 */
		private List<Integer> answerList = new ArrayList<>();
		private List<Integer> attackList = new ArrayList<>();
		private int expectedBlowCount = 0;
		private int actualBlowCount = 0;

		/* イニシャライザ */
		{
			answerList.add(0);
			answerList.add(1);
			answerList.add(2);
		}

		@ParameterizedTest
		@CsvSource({
			"9, 9, 9"
		})
		@DisplayName("並び_012_のうち数字が0個")
		void 並び_012_のうち数字が0個(int num1, int num2, int num3) {
			expectedBlowCount = 0;

			attackList.add(num1); attackList.add(num2); attackList.add(num3);
			actualBlowCount = numeronService.getBlowCount(answerList, attackList);
			assertEquals(expectedBlowCount, actualBlowCount);
			attackList.clear();
		}

		@ParameterizedTest
		@CsvSource({
			"9, 0, 9",
			"9, 9, 0",
			"1, 9, 9",
			"9, 9, 1",
			"2, 9, 9",
			"9, 2, 9"
		})
		@DisplayName("並び_012_のうち数字が1個")
		void 並び_012_のうち数字が1個(int num1, int num2, int num3) {
			expectedBlowCount = 1;

			attackList.add(num1); attackList.add(num2); attackList.add(num3);
			actualBlowCount = numeronService.getBlowCount(answerList, attackList);
			assertEquals(expectedBlowCount, actualBlowCount);
			attackList.clear();
		}

		@ParameterizedTest
		@CsvSource({
			"9, 0, 0",
			"1, 9, 1",
			"2, 2, 9",
		})
		@DisplayName("並び_012_のうち1つの数字が2個")
		void 並び_012_のうち1つの数字が2個(int num1, int num2, int num3) {
			expectedBlowCount = 2;

			attackList.add(num1); attackList.add(num2); attackList.add(num3);
			actualBlowCount = numeronService.getBlowCount(answerList, attackList);
			assertEquals(expectedBlowCount, actualBlowCount);
			attackList.clear();
		}

		@ParameterizedTest
		@CsvSource({
			"1, 0, 9",
			"9, 0, 1",
			"1, 9, 0",
		})
		@DisplayName("並び_012_のうち左2つがある")
		void 並び_012_のうち左2つがある(int num1, int num2, int num3) {
			expectedBlowCount = 2;

			attackList.add(num1); attackList.add(num2); attackList.add(num3);
			actualBlowCount = numeronService.getBlowCount(answerList, attackList);
			assertEquals(expectedBlowCount, actualBlowCount);
			attackList.clear();
		}

		@ParameterizedTest
		@CsvSource({
			"2, 9, 1",
			"9, 2, 1",
			"1, 2, 9",
		})
		@DisplayName("並び_012_のうち右2つがある")
		void 並び_012_のうち右2つがある(int num1, int num2, int num3) {
			expectedBlowCount = 2;

			attackList.add(num1); attackList.add(num2); attackList.add(num3);
			actualBlowCount = numeronService.getBlowCount(answerList, attackList);
			assertEquals(expectedBlowCount, actualBlowCount);
			attackList.clear();
		}

		@ParameterizedTest
		@CsvSource({
			"2, 0, 9",
			"2, 9, 0",
			"9, 2, 0",
		})
		@DisplayName("並び_012_のうち端2つがある")
		void 並び_012_のうち端2つがある(int num1, int num2, int num3) {
			expectedBlowCount = 2;

			attackList.add(num1); attackList.add(num2); attackList.add(num3);
			actualBlowCount = numeronService.getBlowCount(answerList, attackList);
			assertEquals(expectedBlowCount, actualBlowCount);
			attackList.clear();
		}

		@ParameterizedTest
		@CsvSource({
			"1, 2, 0",
			"2, 0, 1",
		})
		@DisplayName("並び_012_のうち全ての数字がある")
		void 並び_012_のうち全ての数字がある(int num1, int num2, int num3) {
			expectedBlowCount = 3;

			attackList.add(num1); attackList.add(num2); attackList.add(num3);
			actualBlowCount = numeronService.getBlowCount(answerList, attackList);
			assertEquals(expectedBlowCount, actualBlowCount);
			attackList.clear();
		}
	}

	@Test
	void turnの値を1増やす() {
		/* データの準備 */
		int expectedTurn = 1;

		/* テスト対象メソッド呼び出し */
		numeronService.addturn();
		int actualTurn = numeronService.getTurn();

		/* 検証 */
		assertEquals(expectedTurn, actualTurn);
	}

	@Test
	void 答えのリストが取得できる() {
		try (MockedConstruction<Random> ignore = mockConstruction(
				Random.class,
				(mock, ctx) -> doReturn(0).when(mock).nextInt(anyInt()))) {
			/* データの準備 */
			List<Integer> expectedAnswerList = new ArrayList<>();
			expectedAnswerList.add(0); expectedAnswerList.add(1); expectedAnswerList.add(2);

			/* initメソッドでフィールドに答えのリストがセットされる */
			numeronService.init();

			/* テスト対象メソッド呼び出し */
			List<Integer> actualAnswerList = numeronService.getAnswerList();

			/* 検証 */
			assertEquals(expectedAnswerList, actualAnswerList);
		}
	}

	@Test
	void ターン数が取得できる() {
		/* データの準備 */
		int expectedTurn = 0;

		/* テスト対象メソッドの呼び出し */
		int actualTurn = numeronService.getTurn();

		/* 検証 */
		assertEquals(expectedTurn, actualTurn);
	}

	@Nested
	class 結果が格納されているリストが取得できる {
		/* データの準備 */
		private List<String> expectedRank = new ArrayList<>();
		private List<String> actualRank = null;

		@ParameterizedTest
		@CsvSource({
			"0, A, あいんしゅたいん並み",
			"1, S, ぅんを使い果たした。かぇりみちにお気をつけて",
			"2, A, あいんしゅたいん並み"
		})
		@DisplayName("Sランク境界値周辺")
		void Sランク境界値周辺(int rank, String result, String coment) {
			expectedRank.add(result);
			expectedRank.add(coment);
			actualRank = numeronService.getRank(rank);
			assertEquals(expectedRank, actualRank);
		}

		@ParameterizedTest
		@CsvSource({
			"3, A, あいんしゅたいん並み",
			"4, A, あいんしゅたいん並み",
			"5, B, やるねぇ"
		})
		@DisplayName("Aランク境界値周辺")
		void Aランク境界値周辺(int rank, String result, String coment) {
			expectedRank.add(result);
			expectedRank.add(coment);
			actualRank = numeronService.getRank(rank);
			assertEquals(expectedRank, actualRank);
		}

		@ParameterizedTest
		@CsvSource({
			"6, B, やるねぇ",
			"7, B, やるねぇ",
			"8, C, いっぱんじん"
		})
		@DisplayName("Bランク境界値周辺")
		void Bランク境界値周辺(int rank, String result, String coment) {
			expectedRank.add(result);
			expectedRank.add(coment);
			actualRank = numeronService.getRank(rank);
			assertEquals(expectedRank, actualRank);
		}

		@ParameterizedTest
		@CsvSource({
			"9, C, いっぱんじん",
			"10, C, いっぱんじん",
			"11, D, IQ68のヒト"
		})
		@DisplayName("Cランク境界値周辺")
		void Cランク境界値周辺(int rank, String result, String coment) {
			expectedRank.add(result);
			expectedRank.add(coment);
			actualRank = numeronService.getRank(rank);
			assertEquals(expectedRank, actualRank);
		}

		@ParameterizedTest
		@CsvSource({
			"12, D, IQ68のヒト",
			"13, D, IQ68のヒト",
			"14, ？？？, ちんぱんじぃ"
		})
		@DisplayName("Dランク境界値周辺")
		void Dランク境界値周辺(int rank, String result, String coment) {
			expectedRank.add(result);
			expectedRank.add(coment);
			actualRank = numeronService.getRank(rank);
			assertEquals(expectedRank, actualRank);;
		}
	}
}
