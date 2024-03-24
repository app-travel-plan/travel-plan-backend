package com.travelplan.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.travelplan.dto.request.CriarUsuarioDto;
import com.travelplan.dto.response.UsuarioDto;
import com.travelplan.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping("")
	public ResponseEntity<UsuarioDto> createUsuario(@Valid @RequestBody CriarUsuarioDto dto) {
		return  ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.criarUsuario(dto));
	}
	
	
	
}
