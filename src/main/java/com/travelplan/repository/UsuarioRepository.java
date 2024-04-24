package com.travelplan.repository;

import com.travelplan.model.UsuarioModel;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, UUID> {

	Optional<UsuarioModel> findById(@Param("id") UUID usuarioId);
	
	Optional<UsuarioModel> findByNome(@Param("nome") String nome);
	
	//Optional<UsuarioModel> findByEmail(@Param("email") String email);
	
	UserDetails findByEmail(String email);
	
}
