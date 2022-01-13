package com.springboot.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.web.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;

	@GetMapping({ "/index", "/", "", "/home" })
	public String index(Model model) {

		model.addAttribute("titulo", textoIndex);
		return "index";
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Elian");
		usuario.setApellido("Navelino");
		usuario.setEmail("elian@gmail.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", textoListar);
		return "listar";
	}

	@ModelAttribute("usuarios")
	public List<Usuario> cargarUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Elian", "Navelino", "elian@gmail.com"));
		usuarios.add(new Usuario("Emilia", "Navelino", "emilia@gmail.com"));
		usuarios.add(new Usuario("huguito", "Navelino", "huguito@gmail.com"));
		usuarios.add(new Usuario("Natalia", "Suarez", "huguito@gmail.com"));
		return usuarios;
	}

}