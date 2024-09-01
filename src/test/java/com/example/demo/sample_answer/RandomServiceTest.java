package com.example.demo.sample_answer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mockConstruction;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

import com.example.demo.sample.RandomService;



class RandomServiceTest {
	
	RandomService service = new RandomService();


	@Test
	void 数字の０が取得できる() {
		//24行目でモックを作成
		//25行目で作成したモックの動きを定義している（詳しくは参考資料のmokito使い方系を参照）
		try (MockedConstruction<Random> ignore = mockConstruction(Random.class,
				(mock, ctx) -> doReturn(0).when(mock).nextInt(anyInt()))) {
			
			//上記でRandomクラスの振る舞い（今回はどんな数字が入っていても０を返す）を定義しているため
			//下記で呼び出した時には0が入っている
			int actual = service.getNumber();
			
			assertEquals(0, actual);
		}

	}
	//以下数字が変わるだけなので割愛

	@Test
	void 数字の1が取得できる() {
		try (MockedConstruction<Random> ignore = mockConstruction(Random.class,
				(mock, ctx) -> doReturn(1).when(mock).nextInt(anyInt()))) {

			int actual = service.getNumber();

			assertEquals(1, actual);
		}
	}

	@Test
	void 数字の2が取得できる() {
		try (MockedConstruction<Random> ignore = mockConstruction(Random.class,
				(mock, ctx) -> doReturn(2).when(mock).nextInt(anyInt()))) {

			int actual = service.getNumber();

			assertEquals(2, actual);
		}
	}



}
