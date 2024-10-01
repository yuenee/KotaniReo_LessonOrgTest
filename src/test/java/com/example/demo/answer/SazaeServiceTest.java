package com.example.demo.answer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.demo.mentee.q04_sazae.SazaeService;

class SazaeServiceTest {
	private SazaeService sazaeService = new SazaeService();

	/* 共通データの準備 */
	private String rock = "goo";
	private String scissors = "choki";
	private String paper = "per";

	@Test
	void じゃんけん勝ち() {
		/* データの準備 */
		String actual = null;
		String expected = "win";

		/* 検証 */
		actual = sazaeService.janken(rock, scissors);
		assertEquals(expected, actual);

		actual = sazaeService.janken(scissors, paper);
		assertEquals(expected, actual);

		actual = sazaeService.janken(paper, rock);
		assertEquals(expected, actual);
	}

	@Test
	void じゃんけんあいこ() {
		/* データの準備 */
		String actual = null;
		String expected = "draw";

		/* 検証 */
		actual = sazaeService.janken(rock, rock);
		assertEquals(expected, actual);

		actual = sazaeService.janken(scissors, scissors);
		assertEquals(expected, actual);

		actual = sazaeService.janken(paper, paper);
		assertEquals(expected, actual);
	}

	@Test
	void じゃんけん負け() {
		/* データの準備 */
		String actual = null;
		String expected = "lose";

		/* 検証 */
		actual = sazaeService.janken(rock, paper);
		assertEquals(expected, actual);

		actual = sazaeService.janken(scissors, rock);
		assertEquals(expected, actual);

		actual = sazaeService.janken(paper, scissors);
		assertEquals(expected, actual);
	}
}
