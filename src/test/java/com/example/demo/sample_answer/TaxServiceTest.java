package com.example.demo.sample_answer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.anyInt;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.sample.TaxService;


@ExtendWith(MockitoExtension.class) 
// JUnit5でMockito使うには必要
class TaxServiceTest {

	//@Spy // 一部のメソッドだけモックにしたいときはこれを定義
	@Spy
	TaxService service;

	@Test
	void 税込金額が取得できる() {


		doReturn(20.0).when(service).getTax(anyInt());
		//上記でgetTax()の動きを定義
		//今回は引数がどんな値でも20.0をリターンするように定義

		double actual =  service.getTaxCalcResult(100);

		assertEquals(120.0, actual);
	}

	
	@Test
	void 税の値が取得できる() {

		double actual =  service.getTax(200);

		assertEquals(40.0, actual);
	}
}
