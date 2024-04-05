package com.travelplan.model;

import java.io.Serializable;
import java.util.UUID;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class UsuarioModel implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idUser;
	private String nome;
	private String celular;
	private String dataNascimento;
	private String cpf;
	private String email;
	private String senha;

}
