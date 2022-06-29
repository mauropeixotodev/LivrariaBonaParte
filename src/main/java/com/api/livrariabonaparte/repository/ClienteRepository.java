package com.api.livrariabonaparte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.livrariabonaparte.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
