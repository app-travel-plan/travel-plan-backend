package com.travelplan.dto.request;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.travelplan.dto.response.UsuarioDto;
import com.travelplan.model.UsuarioRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {

	private String nome;
	
	private String dataNascimento;
	
	private String celular;
	
	private String cpf;
	
	private String email;
	
	private String password;	
	
	private UsuarioRole role;
	
}
