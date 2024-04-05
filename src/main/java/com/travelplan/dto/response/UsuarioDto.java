package com.travelplan.dto.response;

import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto implements Serializable {

	@JsonProperty("idUser")
	private UUID idUser;
	
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
