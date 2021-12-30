package com.springboot.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.web.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@GetMapping({"/index", "/","", "/home"})
	public String index(Model model){
		
		model.addAttribute("titulo", "Hola SpringBoot");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Elian");
		usuario.setApellido("Navelino");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del Usuario: ".concat(usuario.getNombre()));
		return "perfil";
	}
}