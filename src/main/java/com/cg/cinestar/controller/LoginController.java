package com.cg.cinestar.controller;


import com.cg.cinestar.service.jwt.JwtService;
import com.cg.cinestar.model.dto.UserDTO;
import com.cg.cinestar.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private IUserService userService;
//    @GetMapping("/")
//    public String showHome() {
//        return "redirect:/home";
//    }

    @GetMapping("/")
    public ModelAndView showHome(@CookieValue(value = "JWT" , defaultValue = "hello") Long fooCookie) {
        ModelAndView modelAndView = new ModelAndView("/login");
        Long id = Long.valueOf(jwtService.getUserNameFromJwtToken(String.valueOf(fooCookie)));
        Optional<UserDTO> userDTO = userService.unlockUser(id);

//        if(userDTO.get().getRole().getId() == 1) {
//            modelAndView = new ModelAndView("/homeUser");
//            modelAndView.addObject("user",userDTO.get());
//        }else {
//            modelAndView = new ModelAndView("/home");
//            modelAndView.addObject("user",userDTO.get());
//        }

        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView getLogin() {
        return new ModelAndView("/login");
    }
}
