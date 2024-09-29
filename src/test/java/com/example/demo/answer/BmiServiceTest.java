package com.example.demo.answer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.demo.mentee.q02_bmi.BmiService;

class BmiServiceTest {

	@Test
	void BMIが正しく計算される() {
		BmiService bmiService = new BmiService();

		assertEquals(23.5, bmiService.getBmiCalcResult(1.75, 72), 0.1);
	}
}
