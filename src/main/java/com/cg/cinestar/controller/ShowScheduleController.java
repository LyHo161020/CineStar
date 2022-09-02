package com.cg.cinestar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/show_schedules")
public class ShowScheduleController {

    @GetMapping
    public ModelAndView showSchedules() {
        return new ModelAndView("/show_schedule/list_schedule");
    }
}
