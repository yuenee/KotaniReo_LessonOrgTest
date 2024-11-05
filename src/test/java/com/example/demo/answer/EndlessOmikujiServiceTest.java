package com.example.demo.answer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.demo.mentee.q07_endlessomikuji.EndlessOmikujiService;

class EndlessOmikujiServiceTest {
	@Test
	void 戻り値として凶が返ってくる() {
		EndlessOmikujiService endlessOmikujiService = new EndlessOmikujiService();

		/* データの準備 */
		String expected = "凶";

		/* テスト対象メソッドの実行 */
		String actual = endlessOmikujiService.getResult();

		/* 検証 */
		assertEquals(expected, actual);
	}

}
