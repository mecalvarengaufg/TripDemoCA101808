package com.claseafe.Proyecto1UFG.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.claseafe.Proyecto1UFG.model.Trip;
import com.claseafe.Proyecto1UFG.service.ICategoriaService;
import com.claseafe.Proyecto1UFG.service.ITripService;
import com.claseafe.Proyecto1UFG.service.db.TripServiceJpa;

@Controller
@RequestMapping("/trips")
public class tripController {

	@Autowired
	//private ITripService serviceTrip;
	private TripServiceJpa serviceTrip;
	
	@Autowired
	private ICategoriaService categoriaService;
	
    @GetMapping("/create")
    public String crear(Model model) {
        Trip trip = new Trip();
        model.addAttribute("trip", trip);
        model.addAttribute("categorias", categoriaService.buscarTodos());
        return "trips/formTrip";
    }
	
	@PostMapping("/save")
	public String guardar(Trip trip, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			return "trips/formTrip";
		}
		serviceTrip.guardar(trip);
		attributes.addFlashAttribute("msg", "Registro Guardado");
		
		return "redirect:/trips/index";
	}
	
	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idTrip, Model model) {
		System.out.println("IdTrip es: " + idTrip);
		model.addAttribute("id" , idTrip);
		
		return "mensaje";
	}
	
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idTrip, Model model) {
		Trip trip = serviceTrip.buscarPorId(idTrip);
		System.out.println("Trip: " + trip);
		model.addAttribute("Trips: ", trip);
		
		return "detalle";
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
	    model.addAttribute("trips", serviceTrip.buscarTodos());
	    return "trips/index";
	}

	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
