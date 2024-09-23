package com.example.demo.answer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.demo.mentee.q04_sazae.SazaeService;

class SazaeServiceTest {

	@Test
	void じゃんけんの勝敗を決める() {
		SazaeService sazaeService = new SazaeService();

		// 勝ち
		assertEquals("win", sazaeService.janken("goo", "choki"));
		assertEquals("win", sazaeService.janken("choki", "per"));
		assertEquals("win", sazaeService.janken("per", "goo"));

		// あいこ
		assertEquals("draw", sazaeService.janken("goo", "goo"));
		assertEquals("draw", sazaeService.janken("choki", "choki"));
		assertEquals("draw", sazaeService.janken("per", "per"));

		// 負け
		assertEquals("lose", sazaeService.janken("goo", "per"));
		assertEquals("lose", sazaeService.janken("choki", "goo"));
		assertEquals("lose", sazaeService.janken("per", "choki"));
	}
}
