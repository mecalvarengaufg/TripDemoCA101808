package com.claseafe.Proyecto1UFG.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.claseafe.Proyecto1UFG.model.Trip;
import com.claseafe.Proyecto1UFG.service.ITripService;

@Controller
public class HomeController {

    @Autowired
    private ITripService tripService;

    @GetMapping("/")
    public String mostrarHome(Model model) {
        List<Trip> lista = tripService.buscarTodos();
        model.addAttribute("trips", lista);
        
        return "home";
    }
    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idTrip, Model model) {
        Trip trip = tripService.buscarPorId(idTrip);
        System.out.println("ID del Trip es: " + idTrip);
        model.addAttribute("trip" , trip);
        
        return "detalle";
    }
}


