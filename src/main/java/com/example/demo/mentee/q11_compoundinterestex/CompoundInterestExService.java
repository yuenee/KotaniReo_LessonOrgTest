package com.example.demo.mentee.q11_compoundinterestex;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CompoundInterestExService {

    /**
     * <pre>
     * 【問題文】
     * getPriceListは引数のprincipal(元金)、rate(金利)、years(年数)を用いて、
     * 各年の複利計算結果を取得するメソッドです。
     * ・各年の複利計算結果を取得する処理を記載してください。
     * ・各年の複利計算結果は変数listに格納して返却してください。
     * </pre>
     *
     * @param principal 画面で入力した元金
     * @param rate 画面で入力した金利
     * @param year 画面で入力した経過年数
     * @return list 各年の複利計算結果
     */
    public List<Double> getPriceList(int principal, double rate, int year) {
        List<Double> list = new ArrayList<>();
        double result = principal;

        for (int i = 0; i < year; i++) {
            result = result * (rate / 100 + 1);
            list.add(result);
        }

        return list;
    }

    /**
     * <pre>
     * 【問題文】
     * getIsOveredYearMsgは引数のlist(複利計算結果)、targetPrive(目標金額)を用いて、
     * 複利計算結果が目標金額に到達したかどうかの結果(文字列)を取得するメソッドです。
     * ・複利計算結果が目標金額に到達したかを判定する処理を記載して下さい。
     * ・目標金額に到達したかを判定するには、get OveredTargetPriceYearメソッドを用いてください
     *
     * ・判定後のメッセージを返却してください
     * [目標金額に到達した場合]
     *  getOveredTargetPriceYearメソッドで取得した年数をString型に変換してメッセージに入れてください
     * 	例. SUCCESS_MSG： (到達した年数)年目に達成しました！！！
     * [目標金額に到達しなかった場合]
     * 	例. FAILURE_MSG： 目標金額に到達できませんでした・・・
     * </pre>
     *
     * @param list 計算した各年の複利計算結果
     * @param targetPrice 画面で入力した目標金額
     * @return FAILURE_MSG(目標金額に達成しなかった場合) or SUCCESS_MSG(目標金額に達成した場合)
     */
    public String getIsOveredYearMsg(List<Double> list, int targetPrice) {
        final String SUCCESS_MSG = "年目に達成！！！";
        final String FAILURE_MSG = "目標金額には及ばず・・・";
        int overedYear = getOveredTargetPriceYear(list, targetPrice);

        if (overedYear != 0) {
            return String.valueOf(overedYear) + SUCCESS_MSG;
        }

        return FAILURE_MSG;
    }

    /**
     * <pre>
     * 【問題文】
     * getOveredTargetPriceYearは引数のlist(複利計算結果)、targetPrive(目標金額)を用いて
     * 目標金額に到達した年数を取得するメソッドです。
     * ・目標金額に到達した年数を取得する処理を記載してください。
     * ・判定後の年数を返却してください
     * [目標金額に到達した場合]
     * 到達した年数
     * [目標金額に到達しなかった場合]
     * 	0
     * </pre>
     *
     * @param list 計算した各年の複利計算結果
     * @param targetPrice 画面で入力した目標金額
     * @return year 目標金額に到達した年数(到達しなかった場合は0)
     */
    public int getOveredTargetPriceYear(List<Double> list, int targetPrice) {
        int year = 0;

        for (int i = 0; i < list.size(); i++) {
            if (targetPrice <= list.get(i)) {
                year = i + 1;
                break;
            }
        }
//
//        boolean flg = false;
//        int i = 0;
//        while (!flg) {
//            if (targetPrice >= list.get(i)) {
//                year = i + 1;
//                flg = true;
//            }
//            i += 1;
//        }

        return year;
    }
}
