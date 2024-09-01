package com.example.demo.mentee.q04_sazae;

import org.springframework.stereotype.Service;

@Service
public class SazaeService {
    /**
     * <pre>
     * 【問題文】
     * jankenは、引数の myHand(自分の手) とopponentHand(相手の手)を使用して、
     * じゃんけんの勝敗を取得するメソッドです。 
     * ・じゃんけんの勝敗(win,lose,drawの何れか)を取得する処理を記載してください。
     * ・じゃんけんの勝敗は変数resultに格納して返却してください。
     * 例：
     * myHand = "goo", opponentHand = "choki"
     * return "win"
     * </pre>
     *
     * @param myHand 自分の手 goo,choki,per のいずれかの文字列
     * @param opponentHand 相手の手 goo,choki,per のいずれかの文字列
     * @return result win,lose,draw のいずれかの文字列
     * @throws IllegalArgumentException myHand または opponentHand が goo,choki,per のいずれかでない場合
     */
    public String janken(String myHand, String opponentHand) {
        String result = null;

        switch (myHand) {
            case "goo":
                switch (opponentHand) {
                    case "goo":   result = "draw"; break;
                    case "choki": result = "win"; break;
                    case "per":   result = "lose"; break;
                }
                break;
            case "per":
                switch (opponentHand) {
                    case "goo":   result = "win"; break;
                    case "choki": result = "lose"; break;
                    case "per":   result = "draw"; break;
                }
                break;
            case "choki":
                switch (opponentHand) {
                    case "goo":   result = "lose"; break;
                    case "choki": result = "draw"; break;
                    case "per":   result = "win"; break;
                }
        }
/*　【ifの例】
        if ("goo".equals(myHand)) {
            if ("goo".equals(opponentHand))   result = "draw";
            if ("choki".equals(opponentHand)) result = "win";
            if ("per".equals(opponentHand))   result = "lose";
        }
        if ("choki".equals(myHand)) {
            if ("goo".equals(opponentHand))   result = "win";
            if ("choki".equals(opponentHand)) result = "lose";
            if ("per".equals(opponentHand))   result = "draw";
        }
        if ("per".equals(myHand)) {
            if ("goo".equals(opponentHand))   result = "lose";
            if ("choki".equals(opponentHand)) result = "draw";
            if ("per".equals(opponentHand))   result = "win";
        }
*/
//        throw new IllegalArgumentException("引数はgoo, choki, perの3種類にしてください。");
        return result;
    }
}
