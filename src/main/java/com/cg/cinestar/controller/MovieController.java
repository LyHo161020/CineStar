package com.cg.cinestar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/movies")
public class MovieController {
    @GetMapping
    public ModelAndView getHome() {
        return new ModelAndView("/movie/list_movie");
    }
    @GetMapping("/movies/{id}")
    public ModelAndView getDescription() {
        return new ModelAndView("/customer/movie_description");
    }
}
