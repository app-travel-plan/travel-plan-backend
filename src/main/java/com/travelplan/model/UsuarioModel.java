package com.travelplan.model;

import java.io.Serializable;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "USUARIOS")
public class UsuarioModel implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idUser;
	private String email;
	private String senha;
	private Integer telefone;
	
	public UUID getIdUser() {
		return idUser;
	}
	public void setIdUser(UUID idUser) {
		this.idUser = idUser;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Integer getTelefone() {
		return telefone;
	}
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	
}
