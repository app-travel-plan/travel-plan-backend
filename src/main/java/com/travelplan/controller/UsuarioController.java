package com.travelplan.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.travelplan.dto.request.RegisterDTO;
import com.travelplan.dto.response.UsuarioDto;
import com.travelplan.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("users")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@DeleteMapping("{usuarioId}")
	public ResponseEntity<Object> deleteUsuario(@PathVariable(name = "usuarioId", required = true) UUID usuarioId) {
		return usuarioService.deletarUsuario(usuarioId);
	}
	
	@GetMapping("")
	public ResponseEntity<Object> getUsuario() {
		return usuarioService.buscarUsuario();
	}
	
	@GetMapping("{usuarioId}")
	public ResponseEntity<Object> getUsuarioId(@PathVariable(name = "usuarioId", required = true) UUID usuarioId) {
		return usuarioService.buscarUsuarioId(usuarioId);
	}
	
}
