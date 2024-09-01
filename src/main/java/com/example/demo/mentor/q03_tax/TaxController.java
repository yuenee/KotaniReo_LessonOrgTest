package com.example.demo.mentor.q03_tax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.mentee.q03_tax.TaxService;

@Controller
public class TaxController {

	@Autowired
	TaxService taxService;

	@GetMapping({"/tax/", "/tax/home"})
	public String getHome(TaxFormModel taxFormModel, Model model) {
		model.addAttribute("taxFormModel", taxFormModel);
		return "q03_tax/home";
	}

	@PostMapping("/tax/result")
	public String getResult(@ModelAttribute @Validated TaxFormModel taxFormModel, BindingResult bindingResult , Model model) {

		// バリデーションエラー時の処理
		if (bindingResult.hasErrors()) {
			model.addAttribute(taxFormModel);
			return getHome(taxFormModel, model);
		}

		// 税抜き金額(入力値)
		int priceWithoutTax = taxFormModel.getPriceWithoutTax();

		// 税込計算メソッドを呼び出し
		double taxResult = taxService.getTaxCalcResult(priceWithoutTax);

		// 税率取得
		double taxRate = taxService.getTaxRate();

		// Modelに格納
		model.addAttribute("priceWithoutTax", priceWithoutTax);
		model.addAttribute("taxResult", taxResult);
		model.addAttribute("taxRate", taxRate);

		return "q03_tax/result";
	}

}
