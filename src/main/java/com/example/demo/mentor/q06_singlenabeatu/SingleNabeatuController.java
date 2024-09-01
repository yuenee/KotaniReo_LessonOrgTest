package com.example.demo.mentor.q06_singlenabeatu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.mentee.q06_singlenabeatu.SingleNabeatuService;
import com.example.demo.mentor.q08_nabeatu.NabeatuForm;

@Controller
@RequestMapping("single_nabeatu")
public class SingleNabeatuController {
    @Autowired
    SingleNabeatuService service;

    @GetMapping("/")
    public String getHome(@ModelAttribute NabeatuForm nabeatuForm,Model model) {
        model.addAttribute("nabeatuForm", nabeatuForm);
        return "q06_singlenabeatu/index";
    }

    @PostMapping("/result")
    public String getResult(@ModelAttribute @Validated NabeatuForm nabeatuForm,BindingResult bindingResult,Model model) {
    	
		//バリデーションエラー時
		if(bindingResult.hasErrors()) {
			return getHome(nabeatuForm,model);
		}
    	
        int number = nabeatuForm.getNumber();

        model.addAttribute("nabeatuForm", nabeatuForm);
        if (service.isAhoNumber(number)) {
            return "q06_singlenabeatu/nabeatu_number";
        }
        return "q06_singlenabeatu/no_nabeatu_number";
    }
}
