package com.travelplan.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.travelplan.dto.request.CriarUsuarioDto;
import com.travelplan.dto.response.UsuarioDto;
import com.travelplan.model.UsuarioModel;
import com.travelplan.repository.UsuarioRepository;

import jakarta.validation.constraints.NotNull;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	public ResponseEntity<Object> criarUsuario(@NotNull CriarUsuarioDto dto) {
		Optional<UsuarioModel> email = usuarioRepository.findByEmail(dto.getEmail());
		
		if(email.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario already exists");
		}
		
		UsuarioModel DtoToUsuario = UsuarioModel.builder()
				.nome(dto.getNome())
				.email(dto.getEmail())
				.senha(dto.getSenha())
				.build();
		
		usuarioRepository.save(DtoToUsuario);
		
		UsuarioDto usuarioToDto = UsuarioDto.builder()
				.idUser(DtoToUsuario.getIdUser())
				.nome(DtoToUsuario.getNome())
				.email(DtoToUsuario.getEmail())
				.senha(DtoToUsuario.getSenha())
				.build();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioToDto);
	}
	
	public ResponseEntity<Object> deletarUsuario(@NotNull UUID usuarioId) {
		Optional<UsuarioModel> usuario = usuarioRepository.findById(usuarioId);
		
		if(usuario.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario not found");
		}
		
		usuarioRepository.delete(usuario.get());
		
		return ResponseEntity.status(HttpStatus.OK).body("Usuario deleted successfully");
	}
	
	public ResponseEntity<Object> buscarUsuario() {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findAll());
	}
	
	public ResponseEntity<Object> buscarUsuarioId(@NotNull UUID usuarioId) {
		Optional<UsuarioModel> usuario = usuarioRepository.findById(usuarioId);
		
		if(usuario.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario not found");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}
	
	public ResponseEntity<Object> atualizarUsuario(@NotNull UUID usuarioId, @NotNull CriarUsuarioDto dto) {
		UsuarioModel usuario = usuarioRepository.findById(usuarioId);
		
		if(usuario.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario not found");
		}
		
		usuario.setNome(dto.getNome());
		usuario.setEmail(dto.getEmail());
		usuario.setSenha(dto.getSenha());
		
		usuarioRepository.save(usuario);
		
		UsuarioDto usuarioToDto = UsuarioDto.builder()
				.idUser(usuario.getIdUser())
				.nome(usuario.getNome())
				.email(usuario.getEmail())
				.senha(usuario.getSenha())
				.build();
		
		
		return ResponseEntity.status(HttpStatus.OK).body(usuarioToDto);
	}
	
}
