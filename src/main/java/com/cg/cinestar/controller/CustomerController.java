package com.cg.cinestar.controller;


import com.cg.cinestar.model.dto.MovieDTO;
import com.cg.cinestar.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping
    public ModelAndView getListNowShowing() {
        return new ModelAndView("/customer/list_nowShowing");
    }
}

