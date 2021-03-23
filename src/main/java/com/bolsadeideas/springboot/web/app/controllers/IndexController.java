package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("app")
public class IndexController {

	@GetMapping(value = { "/index", "/", "/home" })
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring Framwork");
		return "index"; // necesitamos crear una plantilla index.html
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Andres"); 
		usuario.setApellido("Apellido");
		usuario.setEmail("andres@correo.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del Usuario:".concat(usuario.getNombre()));
		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {		
//		List<Usuario> usuarios= new ArrayList<Usuario>();
//		usuarios.add(new Usuario("Andrés","Guzman","andres@correo.com"));
//		usuarios.add(new Usuario("John","Doe","john@correo.com"));
//		usuarios.add(new Usuario("Jane","Doe","jane@correo.com"));
		List<Usuario> usuarios= Arrays.asList(new Usuario("Andrés","Guzman","andres@correo.com"),
				new Usuario("John","Doe","john@correo.com"),
				new Usuario("Jane","Doe","jane@correo.com"),
				new Usuario("Tornado","Roe","roe@correo.com"));
		model.addAttribute("titulo", "Listado de usuarios:");
		model.addAttribute("usuarios", usuarios);
		return "listar";
	}
	
}



//@RequestMapping(value="/index", method=RequestMethod.GET)
//public String index() {
//	return "index"; //necesitamos crear una plantilla index.html
//}

///*Este es equivalente al anterior */
//@GetMapping(value="/index")
//public String index() {
//	return "index"; //necesitamos crear una plantilla index.html
//}

//@GetMapping(value= {"/index","/","/home"})
//public String index(Model model) {
//	model.addAttribute("titulo","Hola Spring Framwork");
//	return "index"; //necesitamos crear una plantilla index.html
//}

/* Este es equivalente al anterior */
//@GetMapping(value= {"/index","/","/home"})
//public String index(ModelMap model) {
//	model.addAttribute("titulo","Hola Spring Framwork");
//	return "index"; //necesitamos crear una plantilla index.html
//}

/* Este es equivalente al anterior */
//@GetMapping(value= {"/index","/","/home"})
//public String index(Map<String,Object> map) {
//	map.put("titulo","Hola Spring Framwork con Map");
//	return "index"; //necesitamos crear una plantilla index.html
//}

/* Este es equivalente al anterior */
//@GetMapping(value= {"/index","/","/home"})
//public ModelAndView index(ModelAndView mv) {
//	mv.addObject("titulo","Hola Spring Framwork con ModelAndView");
//	mv.setViewName("index");
//	return mv;
//}