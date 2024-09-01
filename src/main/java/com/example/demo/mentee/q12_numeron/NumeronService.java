package com.example.demo.mentee.q12_numeron;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class NumeronService {
    /**
     * <pre>
     *【問題文】
     * 下記の内容をフィールド変数として宣言してください
     * ＊以下の問題はここで宣言したものを使用します
     * ・答えの数列(answerList)
     * ・入力数列(attackList)
     * ・ターン数(turn)
     * </pre>
     */
	List<Integer> answerList = new ArrayList<>();
	List<Integer> attackList = new ArrayList<>();
	int turn;

    /**
     * <pre>
     *【問題文】
     * initメソッドを呼び出す引数無しのコンストラクタを定義してください
     * </pre>
     */
    public NumeronService() {
    	init();
    }

    /**
     * <pre>
     *【問題文】
     *　initは、答えの数列(3桁)の値を格納したList型の値を返却するメソッドです。
     *　・答えの数列(3桁)の値を格納したList型の値を返却してください
     * ※返却に使用するList型は、先で定義したanswerListを用いてください
     * </pre>
     * @return answerList ランダム数値3桁が格納されるリスト(答えの数列)
     */
    public List<Integer> init() {
    	
    	//ターン数(turn)を初期化
    	this.turn = 0;
    	
        //answerListを初期化
        answerList.clear();
    	
        ArrayList<String> list = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        
        for (int i = 0; i < 3; i++) {
            Random random = new Random();
            int index = random.nextInt(list.size());
            answerList.add(Integer.parseInt(list.get(index)));
            list.remove(index);
        }
        return answerList;
    }

    /**
     * <pre>
     *【問題文】
     * getAttackResultは引数のanswerlist(答えの数列)内の数値とattackNumber(String型の入力数値)が持つ数値の
     * 合致判定をするメソッドです。
     * ・合致判定処理を記載してください。
     * ※合致判定は数値List型同士(answerlist, attackList)で行ってください
     * ※attackNumberは3桁のString型数字のため、int型に変換のうえ定義済みのattackListに1桁ずつ格納してください。
     *  また、合致判定は
     *  数値・場所共にあっている判定(getHitCountメソッドの呼び出し)
     *  数値のみあっている判定(getBlowCountメソッドの呼び出し)を行い、
     *  判定結果をInteger型List、attackResultに格納してください。
     *  attackResultの0番目の要素にはhitResultの結果
     *  attackResultの1番目の要素にはblowResultの結果
     * </pre>
     * @param answerList ランダム数値3桁が格納されるリスト(答えの数列)
     * @param attackNumber  入力したString型の数字が格納される(入力数字)
     * @return attackResult
     */
    public List<Integer> getAttackResult(List<Integer> answerList, String attackNumber) {
    	
    	//attackListを初期化
    	attackList.clear();

        // attackNumberを1桁区切りにして、String型ListのnumberListに格納
    	List<String> numberList = new ArrayList<>(Arrays.asList(attackNumber.split("")));

        // String⇒intに変換のうえ、attackListに格納
		for (int i = 0; i <= 2; i++) {
			attackList.add(Integer.parseInt(numberList.get(i)));
		}

        // hitResultにgetHitCount呼び出し結果を格納
        int hitResult = getHitCount(answerList, attackList);
        
        // blowResultにgetBlowCount呼び出し結果を格納
        int blowResult = getBlowCount(answerList, attackList);

        // attackResultに判定結果を格納
        List<Integer> attackResult = new ArrayList<>(Arrays.asList(hitResult, blowResult));

        return attackResult;
    }

    /**
     * <pre>
     *【問題文】
     *　getHitCountは、引数のanswerlist(答えの数列)とattackList(入力数列)において、
     * 数値・場所共にあっている数字がいくつあるかを判定するメソッドです。
     * ・判定処理を記載してください。
     * ・判定結果(あっている数)をint型の変数hitCountを定義して格納してください。
     * </pre>
     * @param answerList 答えの数列
     * @param attackList 入力数列
     * @return hitCount 数値・場所共にあっている数
     */
    public int getHitCount(List<Integer> answerList, List<Integer> attackList) {
        // 数値と場所があっている場合の判定
        int hitCount = 0;
        for (int i = 0; i < 3; i++) {
            if (answerList.get(i) == attackList.get(i)) {
                hitCount++;
            }
        }
        return hitCount;
    }

    /**
     * <pre>
     *【問題文】
     * getBlowCountは引数のanswerlist(答えの数列)とattackList(入力数列)において、
     * 場所は違うが、数値があっている数字がいくつあるかを判定するメソッドです。
     * ・判定処理を記載してください。
     * ・判定結果(あっている数)をint型の変数blowCountを定義して格納してください。
     * </pre>
     * @param answerList 答えの数列
     * @param attackList 入力数列
     * @return blowCount 数値のみあっている数
     */
    public int getBlowCount(List<Integer> answerList, List<Integer> attackList) {
        // 数値を使用しているが、場所があっていない場合の判定
        int blowCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    if (answerList.get(i) == attackList.get(j)) {
                        blowCount++;
                    }
                }
            }
        }
        return blowCount;
    }

    /**
     * <pre>
     *【問題文】
     *　addturnは、アタック毎にターン数を経過させるメソッドです。
     * ・ターン数を経過させるメソッドを定義してください。
     * </pre>
     */
    public void addturn() {
        turn += 1;
    }

    /**
     * <pre>
     * 【問題文】
     *  getAnswerListはフィールド変数で宣言したanswerListを返却するメソッドです。
     * </pre>
     * @return answerList 答えのリスト
     */
    public List<Integer> getAnswerList() {
        return this.answerList;
    }

    /**
     * <pre>
     * 【問題文】
     *  getTurnはフィールド変数で宣言したturnを返却するメソッドです。
     *  </pre>
     *  @return turn ターン数
     */
    public int getTurn() {
        return this.turn;
    }

    /**
     * <pre>
     *【問題文】
     * getRankは、引数のturn(経過ターン数)に応じて、称号を判定するメソッドです。
     * ・称号を判定する処理を記載してください。
     * ・判定結果はString型Listに格納して返却してください。
     *  rankの0番目の要素にはランクの結果
     *  rankの1番目の要素にはメッセージの結果
     * ※ターン数に応じた、ランク付け・メッセージは任意のモノを指定
     *  </pre>
     *  @param turn 経過ターン数
     *  @return rank　
     */
    public List<String> getRank(int turn) {
        List<String> rank = new ArrayList<>(2);

        if (turn == 1) {
            rank.add("S");
            rank.add("ぅんを使い果たした。かぇりみちにお気をつけて");
        } else if (turn <= 4) {
            rank.add("A");
            rank.add("あいんしゅたいん並み");
        } else if (turn <= 7) {
            rank.add("B");
            rank.add("やるねぇ");
        } else if (turn <= 10) {
            rank.add("C");
            rank.add("いっぱんじん");
        } else if (turn <= 13) {
            rank.add("D");
            rank.add("IQ68のヒト");
        } else {
            rank.add("？？？");
            rank.add("ちんぱんじぃ");	
        }
        return rank;
    }

}
