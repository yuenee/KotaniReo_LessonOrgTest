package com.example.demo.mentor.q07_endlessomikuji;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.mentee.q07_endlessomikuji.EndlessOmikujiService;

@Controller
@RequestMapping("endlessOmikuji")
public class EndlessOmikujiController {

    @Autowired
    EndlessOmikujiService service;

    @GetMapping("/")
    public String getHome(Model model) {
        return "q07_endlessomikuji/index";
    }

    @GetMapping("/result")
    public String getResult(Model model) {
        String fortuneMessage = service.getResult();

        model.addAttribute("fortuneMessage", fortuneMessage);

        return "q07_endlessomikuji/result";
    }
}
