package com.example.demo.sample_answer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.demo.sample.AddService;

//テストコード
class AddServiceTest {
	
	//AddServiceをインスタンス化
	AddService service = new AddService();
	
	//実際にテストを行うメソッドが以下となる
	//@Testはテストしたいメソッドの前に記述すること。
	//メソッド名には日本語が使える。
	@Test
	void 足し算の結果が取得できる() {
		// setup(準備)
		//今回は準備の必要なし
		
		// run(実行)
		//対象のメソッドを呼び出し、結果をactualに代入
		double actual = service.add(1, 2);
		
		// assert(結果)
		//assertEquals(期待値, 実際の実行結果);
		assertEquals(3, actual);
	}
}