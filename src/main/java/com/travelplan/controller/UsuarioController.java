package com.travelplan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.travelplan.repository.UsuarioRepository;

@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	
}
