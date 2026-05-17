package com.claseafe.Proyecto1UFG.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.claseafe.Proyecto1UFG.model.Categoria;
import com.claseafe.Proyecto1UFG.service.ICategoriaService;

@Controller
@RequestMapping(value="/categorias")
public class categoriaTripController {

	@Autowired
	private ICategoriaService serviceCategoria;
	
	//@RequestMapping(value = "/index", method = RequestMethod.GET)
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Categoria> lista = serviceCategoria.buscarTodos();
		model.addAttribute("categorias", lista);
		return "categoriasTrip/listCategoria";
	}

	//@RequestMapping(value = "/create", method = RequestMethod.GET)
	@GetMapping("/create")
	public String crear(Model model) {
		model.addAttribute("categoria", new Categoria());
		return "categoriasTrip/formCategoria";
	}

	//@RequestMapping(value = "/save", method = RequestMethod.POST)
	@PostMapping("/save")
	public String guardar(Categoria categoria, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			for (ObjectError error: result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			return "trips/formCategoria";
		}
		System.out.println("Objeto Categoria: " + categoria);
		serviceCategoria.guardar(categoria);
		attributes.addFlashAttribute("msg", "Registro Guardado");
		
		return "redirect:/categorias/index";
	}

}

