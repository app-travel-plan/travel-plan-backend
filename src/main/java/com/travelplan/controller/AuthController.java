package com.travelplan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelplan.dto.request.AuthDTO;
import com.travelplan.dto.request.RegisterDTO;
import com.travelplan.dto.response.LoginResponseDTO;
import com.travelplan.dto.response.UsuarioDto;
import com.travelplan.model.UsuarioModel;
import com.travelplan.repository.UsuarioRepository;
import com.travelplan.security.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private TokenService tokenService;

	@PostMapping("login")
	public ResponseEntity login(@RequestBody @Valid AuthDTO data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.getEmail(), data.getPassword());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		
		var token = tokenService.generateToken((UsuarioModel) auth.getPrincipal());
		
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
	@PostMapping("register")
	public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
		if(this.repository.findByEmail(data.getEmail()) != null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario already exists");
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
		UsuarioModel newUser = new UsuarioModel(data.getNome(), data.getCelular(), data.getDataNascimento(), data.getCpf(), data.getEmail(), encryptedPassword, data.getRole());
		
		this.repository.save(newUser);
		
		UsuarioDto usuarioToDto = UsuarioDto.builder()
				.idUser(newUser.getIdUser())
				.nome(newUser.getNome())
				.celular(newUser.getCelular())
				.dataNascimento(newUser.getDataNascimento())
				.cpf(newUser.getCpf())
				.email(newUser.getUsername())
				.password(newUser.getPassword())
				.role(newUser.getRole())
				.build();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioToDto);
	}
	
}
