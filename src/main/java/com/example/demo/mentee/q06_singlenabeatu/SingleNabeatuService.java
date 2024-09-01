package com.example.demo.mentee.q06_singlenabeatu;

import org.springframework.stereotype.Service;

@Service
public class SingleNabeatuService {

	/**
	 * <pre>
	 * 【問題文】
	 * isAhoNumberは、引数のinputNumber(入力値)がアホになる数値('3を含む数字'または'3の倍数')
	 * かどうかを判定するメソッドです。
	 * ・入力値がアホになる数値('3を含む数字'または'3の倍数')かどうかを判定する処理を記述してください
	 * ・判別結果は変数flgに格納して返却してください。
	 * ※アホになる数値の場合はtrue, アホにならない数値の場合はfalse
	 * </pre>
	 *
	 * @param inputNumber 画面で入力した数字
	 * @return flg アホになる('3を含む数字'または'3の倍数')かどうかの結果
	 */
	public boolean isAhoNumber(int inputNumber) {

		boolean flg;

		if (inputNumber == 0) {
			flg = false;
		} else if (String.valueOf(inputNumber).contains("3") || inputNumber % 3 == 0) {
			flg = true;
		} else {
			flg = false;
		}
		return flg;
		
	}
}
