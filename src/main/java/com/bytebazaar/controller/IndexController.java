package com.bytebazaar.controller;

import com.bytebazaar.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("")
    public String redirect(Model model){
        return "redirect:/bazaar";
    }

    @GetMapping("/bazaar")
    public String index(Model model){
        return "index";
    }
}
