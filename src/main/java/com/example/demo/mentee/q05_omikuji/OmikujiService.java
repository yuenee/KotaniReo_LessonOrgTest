package com.example.demo.mentee.q05_omikuji;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service

public class OmikujiService {
    /**
     * <pre>
     * 【問題文】
     * getResultはおみくじを引いた結果を取得するメソッドです。
     * ・ランダムなおみくじの結果を取得する処理を記載してください。
     * ・おみくじの結果は変数resultに格納して返却してください 例.大吉
     * </pre>
     *
     * @return result おみくじの結果
     */
    public String getResult() {
        Random random = new Random();
        String result = "";
        int randomNum = 0;

        randomNum = random.nextInt(4);
        switch (randomNum) {
        case 0:
            result = "大吉";
            break;
        case 1:
            result = "中吉";
            break;
        case 2:
            result = "小吉";
            break;
        default:
            result = "凶";
        }
        //        if (randomNum == 0) {
        //            result = "大吉";
        //        } else if (randomNum == 1) {
        //            result = "中吉";
        //        } else if (randomNum == 2) {
        //            result = "小吉";
        //        } else {
        //            result = "凶";
        //        }

        return result;
    }

    /**
     * <pre>
     * 【問題文】
     * getResultCommentは引数のresult(おみくじの結果)に紐づいた、コメントを返すメソッドです。
     * ・result(おみくじの結果)に紐づいた、コメントを取得する処理を記載してください。
     * ・コメントはresultCommentに格納して返却してください 例.大吉です、今日はとても良い日でしょう
     * ・条件分岐は引数で渡している'result'を用いてください
     * ※なお、引数のresultはgetResultメソッドで取得した結果が格納されています。
     * </pre>
     *
     * @param result おみくじの結果
     * @return resultComment おみくじ結果に対してのコメント
     */
    public String getResultComment(String result) {
        String resultComment = "";

        //おみくじの結果に紐づいた、コメントを定数として定義
        final String DAIKICHI_COMMENT = "大吉です！きっと明日はいい天気になります。";
        final String TYUKICHI_COMMENT = "中吉です、いつも以上に楽しく過ごせるでしょう";
        final String SYOKICHI_COMMENT = "小吉です、いつものように穏やかに過ごせるでしょう";
        final String KYO_COMMENT = "凶です、忘れ物など身の回りには要注意・・・";

        if (result.equals("大吉")) {
            resultComment = DAIKICHI_COMMENT;
        } else if (result.equals("中吉")) {
            resultComment = TYUKICHI_COMMENT;
        } else if (result.equals("小吉")) {
            resultComment = SYOKICHI_COMMENT;
        } else {
            resultComment = KYO_COMMENT;
        }

        return resultComment;
    }
}
