package com.cg.cinestar.controller;

import com.cg.cinestar.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private IUserService userService;

//    @GetMapping("/user{id}")
//    public ModelAndView showDashboardUser(@PathVariable("id") Long id) {
//        ModelAndView modelAndView = new ModelAndView("/home");
//        Optional<UserDTO> userDTO = userService.findUserDTOByID(id);
//        modelAndView.addObject("user", userDTO.get());
//        return modelAndView;
//    }

    @GetMapping("/admin")
    public ModelAndView showHomeAdmin() {
        ModelAndView modelAndView = new ModelAndView("homeAdmin");
        return modelAndView;
    }

    @GetMapping("/staff")
    public ModelAndView showHomeStaff() {
        ModelAndView modelAndView = new ModelAndView("homeStaff");
        return modelAndView;
    }
}