package com.example.demo.answer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.demo.mentee.q01_introduce.IntroduceService;

class IntroduceServiceTest {
	IntroduceService introduceService = new IntroduceService();

	@Test
	void 自分の名前を取得できる() {
		String actual = introduceService.getName();
		assertEquals("Tarou Tanaka", actual);
	}

	@Test
	void 自己紹介文を取得できる() {
		String actual = introduceService.getComment();
		assertEquals("私はITエンジニアを目指しています。", actual);
	}
}
