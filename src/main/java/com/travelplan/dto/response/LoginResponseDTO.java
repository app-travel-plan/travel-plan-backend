package com.travelplan.dto.response;

import lombok.*;

@Data

public class LoginResponseDTO {

	private String token;
	
	public LoginResponseDTO(String token) {
		this.token = token;
	}
	
}
