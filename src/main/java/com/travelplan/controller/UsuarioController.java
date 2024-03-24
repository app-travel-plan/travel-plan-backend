package com.travelplan.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.travelplan.dto.request.CriarUsuarioDto;
import com.travelplan.dto.response.UsuarioDto;
import com.travelplan.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping("")
	public ResponseEntity<Object> createUsuario(@Valid @RequestBody CriarUsuarioDto dto) {
		return usuarioService.criarUsuario(dto);
	}
	
	@DeleteMapping("{usuarioId}")
	public ResponseEntity<Object> deleteUsuario(@PathVariable(name = "usuarioId", required = true) UUID usuarioId) {
		return usuarioService.deletarUsuario(usuarioId);
	}
	
}
