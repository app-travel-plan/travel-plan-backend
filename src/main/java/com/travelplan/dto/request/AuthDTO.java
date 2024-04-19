package com.travelplan.dto.request;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.travelplan.dto.response.UsuarioDto;

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
public class AuthDTO {

	private String email;
	
	private String password;	
	
}
