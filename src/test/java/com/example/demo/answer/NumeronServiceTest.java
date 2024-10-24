package com.example.demo.answer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

	@Test
	void 合致判定結果が格納されているのリストが取得できる() {
		/* データの準備 */
		List<Integer> expectedAttackResult = new ArrayList<>();
		List<Integer> actualAttackResult = new ArrayList<>();
		String attackNumber = "000";

		/* 全パターン検証 */
		doReturn(0).when(numeronService).getHitCount(anyList(), anyList());
		doReturn(0).when(numeronService).getBlowCount(anyList(), anyList());
		expectedAttackResult.add(0); expectedAttackResult.add(0);
		actualAttackResult = numeronService.getAttackResult(new ArrayList<Integer>(), attackNumber);
		assertEquals(expectedAttackResult, actualAttackResult);
		expectedAttackResult.clear();

		doReturn(0).when(numeronService).getHitCount(anyList(), anyList());
		doReturn(1).when(numeronService).getBlowCount(anyList(), anyList());
		expectedAttackResult.add(0); expectedAttackResult.add(1);
		actualAttackResult = numeronService.getAttackResult(new ArrayList<Integer>(), attackNumber);
		assertEquals(expectedAttackResult, actualAttackResult);
		expectedAttackResult.clear();

		doReturn(0).when(numeronService).getHitCount(anyList(), anyList());
		doReturn(2).when(numeronService).getBlowCount(anyList(), anyList());
		expectedAttackResult.add(0); expectedAttackResult.add(2);
		actualAttackResult = numeronService.getAttackResult(new ArrayList<Integer>(), attackNumber);
		assertEquals(expectedAttackResult, actualAttackResult);
		expectedAttackResult.clear();

		doReturn(1).when(numeronService).getHitCount(anyList(), anyList());
		doReturn(0).when(numeronService).getBlowCount(anyList(), anyList());
		expectedAttackResult.add(1); expectedAttackResult.add(0);
		actualAttackResult = numeronService.getAttackResult(new ArrayList<Integer>(), attackNumber);
		assertEquals(expectedAttackResult, actualAttackResult);
		expectedAttackResult.clear();

		doReturn(1).when(numeronService).getHitCount(anyList(), anyList());
		doReturn(1).when(numeronService).getBlowCount(anyList(), anyList());
		expectedAttackResult.add(1); expectedAttackResult.add(1);
		actualAttackResult = numeronService.getAttackResult(new ArrayList<Integer>(), attackNumber);
		assertEquals(expectedAttackResult, actualAttackResult);
		expectedAttackResult.clear();

		doReturn(1).when(numeronService).getHitCount(anyList(), anyList());
		doReturn(2).when(numeronService).getBlowCount(anyList(), anyList());
		expectedAttackResult.add(1); expectedAttackResult.add(2);
		actualAttackResult = numeronService.getAttackResult(new ArrayList<Integer>(), attackNumber);
		assertEquals(expectedAttackResult, actualAttackResult);
		expectedAttackResult.clear();

		doReturn(2).when(numeronService).getHitCount(anyList(), anyList());
		doReturn(0).when(numeronService).getBlowCount(anyList(), anyList());
		expectedAttackResult.add(2); expectedAttackResult.add(0);
		actualAttackResult = numeronService.getAttackResult(new ArrayList<Integer>(), attackNumber);
		assertEquals(expectedAttackResult, actualAttackResult);
		expectedAttackResult.clear();

		doReturn(2).when(numeronService).getHitCount(anyList(), anyList());
		doReturn(1).when(numeronService).getBlowCount(anyList(), anyList());
		expectedAttackResult.add(2); expectedAttackResult.add(1);
		actualAttackResult = numeronService.getAttackResult(new ArrayList<Integer>(), attackNumber);
		assertEquals(expectedAttackResult, actualAttackResult);
		expectedAttackResult.clear();

		doReturn(2).when(numeronService).getHitCount(anyList(), anyList());
		doReturn(2).when(numeronService).getBlowCount(anyList(), anyList());
		expectedAttackResult.add(2); expectedAttackResult.add(2);
		actualAttackResult = numeronService.getAttackResult(new ArrayList<Integer>(), attackNumber);
		assertEquals(expectedAttackResult, actualAttackResult);
		expectedAttackResult.clear();
	}

	@Test
	void 数値位置がともに合致_数字の個数が取得できる() {
		/* データの準備 */
		List<Integer> answerList = new ArrayList<>();
		List<Integer> attackList = new ArrayList<>();
		int expectedHitCount = 0;
		int actualHitCount = 0;
		answerList.add(0); answerList.add(1); answerList.add(2);

		/* 全て異なる */
		attackList.add(9); attackList.add(9); attackList.add(9);
		actualHitCount = numeronService.getHitCount(answerList, attackList);
		assertEquals(expectedHitCount, actualHitCount);
		attackList.clear();

		/* 1箇所完全一致(3パターン) */
		expectedHitCount = 1;
		attackList.add(0); attackList.add(0); attackList.add(0);
		actualHitCount = numeronService.getHitCount(answerList, attackList);
		assertEquals(expectedHitCount, actualHitCount);
		attackList.clear();

		attackList.add(1); attackList.add(1); attackList.add(1);
		actualHitCount = numeronService.getHitCount(answerList, attackList);
		assertEquals(expectedHitCount, actualHitCount);
		attackList.clear();

		attackList.add(2); attackList.add(2); attackList.add(2);
		actualHitCount = numeronService.getHitCount(answerList, attackList);
		assertEquals(expectedHitCount, actualHitCount);
		attackList.clear();

		/* 2箇所完全一致(3パターン) */
		expectedHitCount = 2;
		attackList.add(9); attackList.add(1); attackList.add(2);
		actualHitCount = numeronService.getHitCount(answerList, attackList);
		assertEquals(expectedHitCount, actualHitCount);
		attackList.clear();

		attackList.add(0); attackList.add(9); attackList.add(2);
		actualHitCount = numeronService.getHitCount(answerList, attackList);
		assertEquals(expectedHitCount, actualHitCount);
		attackList.clear();

		attackList.add(0); attackList.add(1); attackList.add(9);
		actualHitCount = numeronService.getHitCount(answerList, attackList);
		assertEquals(expectedHitCount, actualHitCount);
		attackList.clear();

		/* 3箇所完全一致(1パターン) */
		expectedHitCount = 3;
		attackList.add(0); attackList.add(1); attackList.add(2);
		actualHitCount = numeronService.getHitCount(answerList, attackList);
		assertEquals(expectedHitCount, actualHitCount);
		attackList.clear();
	}

	@Test
	void 数値は合致_位置は異なる_数字の個数が取得できる() {
		/* データの準備 */
		List<Integer> answerList = new ArrayList<>();
		List<Integer> attackList = new ArrayList<>();
		int expectedBlowCount = 0;
		int actualBlowCount = 0;
		answerList.add(0); answerList.add(1); answerList.add(2);

		/* 並び「012」のうち、数字が0個(1パターン) */
		attackList.add(9); attackList.add(9); attackList.add(9);
		actualBlowCount = numeronService.getBlowCount(answerList, attackList);
		assertEquals(expectedBlowCount, actualBlowCount);
		attackList.clear();

		/* 並び「012」のうち、数字が1個ある(3 x 2パターン) */
		expectedBlowCount = 1;
		attackList.add(9); attackList.add(0); attackList.add(9);
		actualBlowCount = numeronService.getBlowCount(answerList, attackList);
		assertEquals(expectedBlowCount, actualBlowCount);
		attackList.clear();

		attackList.add(9); attackList.add(9); attackList.add(0);
		actualBlowCount = numeronService.getBlowCount(answerList, attackList);
		assertEquals(expectedBlowCount, actualBlowCount);
		attackList.clear();

		attackList.add(1); attackList.add(9); attackList.add(9);
		actualBlowCount = numeronService.getBlowCount(answerList, attackList);
		assertEquals(expectedBlowCount, actualBlowCount);
		attackList.clear();

		attackList.add(9); attackList.add(9); attackList.add(1);
		actualBlowCount = numeronService.getBlowCount(answerList, attackList);
		assertEquals(expectedBlowCount, actualBlowCount);
		attackList.clear();

		attackList.add(2); attackList.add(9); attackList.add(9);
		actualBlowCount = numeronService.getBlowCount(answerList, attackList);
		assertEquals(expectedBlowCount, actualBlowCount);
		attackList.clear();

		attackList.add(9); attackList.add(2); attackList.add(9);
		actualBlowCount = numeronService.getBlowCount(answerList, attackList);
		assertEquals(expectedBlowCount, actualBlowCount);
		attackList.clear();

		/* 並び「012」のうち、1つの数字が2個ある(3パターン) */
		expectedBlowCount = 2;
		attackList.add(9); attackList.add(0); attackList.add(0);
		actualBlowCount = numeronService.getBlowCount(answerList, attackList);
		assertEquals(expectedBlowCount, actualBlowCount);
		attackList.clear();

		attackList.add(1); attackList.add(9); attackList.add(1);
		actualBlowCount = numeronService.getBlowCount(answerList, attackList);
		assertEquals(expectedBlowCount, actualBlowCount);
		attackList.clear();

		attackList.add(2); attackList.add(2); attackList.add(9);
		actualBlowCount = numeronService.getBlowCount(answerList, attackList);
		assertEquals(expectedBlowCount, actualBlowCount);
		attackList.clear();

		/* 並び「012」のうち、0と1がある(3パターン) */
		attackList.add(1); attackList.add(0); attackList.add(9);
		actualBlowCount = numeronService.getBlowCount(answerList, attackList);
		assertEquals(expectedBlowCount, actualBlowCount);
		attackList.clear();

		attackList.add(9); attackList.add(0); attackList.add(1);
		actualBlowCount = numeronService.getBlowCount(answerList, attackList);
		assertEquals(expectedBlowCount, actualBlowCount);
		attackList.clear();

		attackList.add(1); attackList.add(9); attackList.add(0);
		actualBlowCount = numeronService.getBlowCount(answerList, attackList);
		assertEquals(expectedBlowCount, actualBlowCount);
		attackList.clear();

		/* 並び「012」のうち、1と2がある(3パターン) */
		attackList.add(2); attackList.add(9); attackList.add(1);
		actualBlowCount = numeronService.getBlowCount(answerList, attackList);
		assertEquals(expectedBlowCount, actualBlowCount);
		attackList.clear();

		attackList.add(9); attackList.add(2); attackList.add(1);
		actualBlowCount = numeronService.getBlowCount(answerList, attackList);
		assertEquals(expectedBlowCount, actualBlowCount);
		attackList.clear();

		attackList.add(1); attackList.add(2); attackList.add(9);
		actualBlowCount = numeronService.getBlowCount(answerList, attackList);
		assertEquals(expectedBlowCount, actualBlowCount);
		attackList.clear();

		/* 並び「012」のうち、2と0がある(3パターン) */
		attackList.add(2); attackList.add(0); attackList.add(9);
		actualBlowCount = numeronService.getBlowCount(answerList, attackList);
		assertEquals(expectedBlowCount, actualBlowCount);
		attackList.clear();

		attackList.add(2); attackList.add(9); attackList.add(0);
		actualBlowCount = numeronService.getBlowCount(answerList, attackList);
		assertEquals(expectedBlowCount, actualBlowCount);
		attackList.clear();

		attackList.add(9); attackList.add(2); attackList.add(0);
		actualBlowCount = numeronService.getBlowCount(answerList, attackList);
		assertEquals(expectedBlowCount, actualBlowCount);
		attackList.clear();

		/* 並び「012」のうち、数字が3個ある(2パターン) */
		expectedBlowCount = 3;
		attackList.add(1); attackList.add(2); attackList.add(0);
		actualBlowCount = numeronService.getBlowCount(answerList, attackList);
		assertEquals(expectedBlowCount, actualBlowCount);
		attackList.clear();

		attackList.add(2); attackList.add(0); attackList.add(1);
		actualBlowCount = numeronService.getBlowCount(answerList, attackList);
		assertEquals(expectedBlowCount, actualBlowCount);
		attackList.clear();
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

	@Test
	void 結果が格納されているリストが取得できる() {
		/* データの準備 */
		List<String> expectedRankS = new ArrayList<>();
		List<String> expectedRankA = new ArrayList<>();
		List<String> expectedRankB = new ArrayList<>();
		List<String> expectedRankC = new ArrayList<>();
		List<String> expectedRankD = new ArrayList<>();
		List<String> expectedRankUnknown = new ArrayList<>();
		expectedRankS.add("S"); expectedRankS.add("ぅんを使い果たした。かぇりみちにお気をつけて");
		expectedRankA.add("A"); expectedRankA.add("あいんしゅたいん並み");
		expectedRankB.add("B"); expectedRankB.add("やるねぇ");
		expectedRankC.add("C"); expectedRankC.add("いっぱんじん");
		expectedRankD.add("D"); expectedRankD.add("IQ68のヒト");
		expectedRankUnknown.add("？？？"); expectedRankUnknown.add("ちんぱんじぃ");
		List<String> actualRank = null;
		
		/* Sランク境界値周辺 */
		actualRank = numeronService.getRank(0);
		assertEquals(expectedRankA, actualRank);
		actualRank = numeronService.getRank(1);
		assertEquals(expectedRankS, actualRank);
		actualRank = numeronService.getRank(2);
		assertEquals(expectedRankA, actualRank);
		
		/* Aランク境界値周辺 */
		actualRank = numeronService.getRank(3);
		assertEquals(expectedRankA, actualRank);
		actualRank = numeronService.getRank(4);
		assertEquals(expectedRankA, actualRank);
		actualRank = numeronService.getRank(5);
		assertEquals(expectedRankB, actualRank);
		
		/* Bランク境界値周辺 */
		actualRank = numeronService.getRank(6);
		assertEquals(expectedRankB, actualRank);
		actualRank = numeronService.getRank(7);
		assertEquals(expectedRankB, actualRank);
		actualRank = numeronService.getRank(8);
		assertEquals(expectedRankC, actualRank);
		
		/* Cランク境界値周辺 */
		actualRank = numeronService.getRank(9);
		assertEquals(expectedRankC, actualRank);
		actualRank = numeronService.getRank(10);
		assertEquals(expectedRankC, actualRank);
		actualRank = numeronService.getRank(11);
		assertEquals(expectedRankD, actualRank);
		
		/* Dランク境界値周辺 */
		actualRank = numeronService.getRank(12);
		assertEquals(expectedRankD, actualRank);
		actualRank = numeronService.getRank(13);
		assertEquals(expectedRankD, actualRank);
		actualRank = numeronService.getRank(14);
		assertEquals(expectedRankUnknown, actualRank);
	}
}
