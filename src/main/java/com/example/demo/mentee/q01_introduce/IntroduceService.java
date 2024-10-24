package com.example.demo.mentee.q01_introduce;

import org.springframework.stereotype.Service;

@Service
public class IntroduceService {
    /**
     * <pre>
     * 【問題文】
     *  getNameはあなたの名前を返すメソッドです。
     *   ・変数nameを定義(あなたの名前を格納)して返却してください。
     * </pre>
     * @return name 自分の名前
     */
	public String getName() {
		String name = "Tarou Tanaka";
		return name;
	}
	
    /**
     * <pre>
     * 【問題文】
     *  getCommentは自己紹介文を返すメソッドです。
     *   ・変数commentを定義(自己紹介文を格納)して返却してください。
     * </pre>
     * @return comment 自己紹介文
     */
	public String getComment() {
		String comment = "私はITエンジニアを目指しています。";
		return comment;
	}
}
