package com.example.demo.mentor.q02_bmi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.mentee.q02_bmi.BmiService;



@Controller
public class BmiController {

	// BMI計算用サービス呼び出し
	@Autowired
	BmiService bmiService;

	@GetMapping({"/bmi/", "/bmi/home"})
	public String getHome(@ModelAttribute BmiFormModel bmiFormModel, Model model) {
		model.addAttribute("bmiFormModel", bmiFormModel);
		return "q02_bmi/home";
	}

	@PostMapping("/bmi/result")
	public String getResult(@ModelAttribute @Validated BmiFormModel bmiFormModel, BindingResult bindingResult ,Model model) {

		// バリデーションエラー時の処理
		if (bindingResult.hasErrors()) {
			return getHome(bmiFormModel, model);
		}

		// 身長(入力値)
		double height = bmiFormModel.getHeight();
		// 体重(入力値)
		double weight = bmiFormModel.getWeight();

		// BMI計算処理
		double bmiResult = bmiService.getBmiCalcResult(height, weight);

		// 肥満度計算処理
		String obesityResult = getObesity(bmiResult);

		// Modelに計算結果を格納
		model.addAttribute("height", height);
		model.addAttribute("weight", weight);
		model.addAttribute("bmiResult", bmiResult);
		model.addAttribute("obesityResult", obesityResult);

		return "q02_bmi/result";
	}

	/**
	 * 肥満度判定メソッド
	 *
	 * @param bmi　bmi計算結果
	 * @return obesity 肥満度
	 */
	public String getObesity(Double bmi) {

		// 結果格納用変数定義
		String obesity = null;

		// 肥満度計算
		if(bmi >= 25.0) {
			obesity = "肥満";
		}else if(bmi < 25.0 && bmi >= 18.5) {
			obesity = "標準";
		}else {
			obesity = "痩せ型";
		}

		return obesity;
	}

}
