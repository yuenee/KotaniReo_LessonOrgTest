package com.example.demo.mentor.q11_compoundinterestex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.mentee.q11_compoundinterestex.CompoundInterestExService;

@Controller
@RequestMapping("compoundInterestEx")
public class CompoundInterestExController {

    @Autowired
    CompoundInterestExService service;

    @GetMapping("/")
    public String getHome(@ModelAttribute CalcExForm calcExForm, Model model) {

        return "q11_compoundinterestex/index";
    }

    @PostMapping("/result")
    public String postResult(@ModelAttribute @Validated CalcExForm calcExForm, BindingResult bindingResult, Model model) {

        //バリデーションエラー時
        if (bindingResult.hasErrors()) {
            return getHome(calcExForm, model);
        }

        int principal = calcExForm.getPrincipal();
        double rate = calcExForm.getRate();
        int years = calcExForm.getYears();
        int targetPrice = calcExForm.getTargetPrice();
        List<Double> calcPriceResultList = service.getPriceList(principal, rate, years); // 隔年の金額のリスト
        String msg = service.getIsOveredYearMsg(calcPriceResultList, targetPrice); // 目標金額に対しての結果

        model.addAttribute("resultPriceList", calcPriceResultList);
        model.addAttribute("overedYearsMsg", msg);

        return "q11_compoundinterestex/result";
    }
}
