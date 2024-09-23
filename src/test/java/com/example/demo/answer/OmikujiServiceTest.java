package com.example.demo.answer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedConstruction;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.mentee.q05_omikuji.OmikujiService;

@ExtendWith(MockitoExtension.class)
class OmikujiServiceTest {
	@Spy
	OmikujiService omikujiService;

	@Test
	void おみくじ結果を取得() {
		// 大吉 Randomクラスの振る舞い定義
		try (MockedConstruction<Random> ignore = mockConstruction(
				Random.class,
				(mock, ctx) -> doReturn(0).when(mock).nextInt(anyInt()))) {
			assertEquals("大吉", omikujiService.getResult());
		}

		// 中吉 Randomクラスの振る舞い定義
		try (MockedConstruction<Random> ignore = mockConstruction(
				Random.class,
				(mock, ctx) -> doReturn(1).when(mock).nextInt(anyInt()))) {
			assertEquals("中吉", omikujiService.getResult());
		}

		// 小吉 Randomクラスの振る舞い定義
		try (MockedConstruction<Random> ignore = mockConstruction(
				Random.class,
				(mock, ctx) -> doReturn(2).when(mock).nextInt(anyInt()))) {
			assertEquals("小吉", omikujiService.getResult());
		}
		
		// 凶 Randomクラスの振る舞い定義
		try (MockedConstruction<Random> ignore = mockConstruction(
				Random.class,
				(mock, ctx) -> doReturn(3).when(mock).nextInt(anyInt()))) {
			assertEquals("凶", omikujiService.getResult());
		}
    }

	@Test
	void おみくじ結果に対してのコメントを取得() {
		//おみくじの結果に紐づいた、コメントを定数として定義
	    final String DAIKICHI_COMMENT = "大吉です！きっと明日はいい天気になります。";
	    final String TYUKICHI_COMMENT = "中吉です、いつも以上に楽しく過ごせるでしょう";
	    final String SYOKICHI_COMMENT = "小吉です、いつものように穏やかに過ごせるでしょう";
	    final String KYO_COMMENT = "凶です、忘れ物など身の回りには要注意・・・";
 
		doReturn("大吉").when(omikujiService).getResult();
		assertEquals(DAIKICHI_COMMENT, omikujiService.getResultComment(omikujiService.getResult()));

		doReturn("中吉").when(omikujiService).getResult();
		assertEquals(TYUKICHI_COMMENT, omikujiService.getResultComment(omikujiService.getResult()));

		doReturn("小吉").when(omikujiService).getResult();
		assertEquals(SYOKICHI_COMMENT, omikujiService.getResultComment(omikujiService.getResult()));

		doReturn("凶").when(omikujiService).getResult();
		assertEquals(KYO_COMMENT, omikujiService.getResultComment(omikujiService.getResult()));
	}
}
