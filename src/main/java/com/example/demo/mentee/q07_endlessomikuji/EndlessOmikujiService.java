package com.example.demo.mentee.q07_endlessomikuji;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class EndlessOmikujiService {
    /**
     * <pre>
     * 【問題文】
     * getResultは"凶"を返却するメソッドです。ただし、以下の条件を処理に含めてください。
     * ・0~3の乱数を取得し、その値が3の場合のみ戻り値として"凶"を返却してください。
     * ・上記の乱数が3以外の場合は、3になるまで繰り返し乱数の取得を行ってください。
     * ・"凶"は変数resultに格納して返却してください。 例.凶
     * </pre>
     *
     * @return result おみくじの結果
     */
    public String getResult() {
        Random random = new Random();
        String result = "";
        int randomNum = 0;
        boolean flg = false;

        while (!flg) {
            randomNum = random.nextInt(4);
            System.out.println(randomNum);
            switch (randomNum) {
            case 3:
                result = "凶";
                flg = true;
                break;
            }
            //            if (randomNum == 3) {
            //                result = "凶";
            //                flg = true;
            //            }
        }

        return result;
    }
}
