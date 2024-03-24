package com.travelplan.service;

import org.springframework.beans.factory.annotation.Autowired;
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

	public UsuarioDto criarUsuario(@NotNull CriarUsuarioDto dto) {
		
		UsuarioModel usuario = UsuarioModel.builder()
				.nome(dto.getNome())
				.email(dto.getEmail())
				.senha(dto.getSenha())
				.build();
		
		usuarioRepository.save(usuario);
		
		return UsuarioDto.builder()
				.idUser(usuario.getIdUser())
				.nome(usuario.getNome())
				.email(usuario.getEmail())
				.senha(usuario.getSenha())
				.build();
		// @formatter:on
	}
	
}
