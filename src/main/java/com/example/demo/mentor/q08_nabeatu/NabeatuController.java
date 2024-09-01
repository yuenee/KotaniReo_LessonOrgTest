package com.example.demo.mentor.q08_nabeatu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.mentee.q08_nabeatu.NabeatuService;;

@Controller
@RequestMapping("nabeatu")
public class NabeatuController {
    @Autowired
    NabeatuService service;

    @GetMapping("/")
    public String getHome(@ModelAttribute NabeatuForm nabeatuForm,Model model) {
        model.addAttribute("nabeatuForm", nabeatuForm);
        return "q08_nabeatu/index";
    }

    @PostMapping("/result")
    public String getResult(@ModelAttribute @Validated NabeatuForm nabeatuForm,BindingResult bindingResult,Model model) {
    	
		//バリデーションエラー時
		if(bindingResult.hasErrors()) {
			return getHome(nabeatuForm,model);
		}
		
        int totalNum = service.getTotalNum(nabeatuForm.getNumber());

        model.addAttribute("totalNum", totalNum);
        if (service.isAhoNumber(totalNum)) {
            return "q08_nabeatu/nabeatu_number";
        }
        return "q08_nabeatu/no_nabeatu_number";
    }
}
