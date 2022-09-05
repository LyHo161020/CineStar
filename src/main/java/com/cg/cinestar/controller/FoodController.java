package com.cg.cinestar.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/foods")
public class FoodController {

    @GetMapping
    public ModelAndView showListFood() {
        return new ModelAndView("food/listFood");
    }
}
