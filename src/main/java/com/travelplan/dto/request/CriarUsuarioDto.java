package com.travelplan.dto.request;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CriarUsuarioDto {

	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("dataNascimento")
	private String dataNascimento;
	
	@JsonProperty("celular")
	private String celular;
	
	@JsonProperty("cpf")
	private String cpf;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("senha")
	private String senha;	
	
}
