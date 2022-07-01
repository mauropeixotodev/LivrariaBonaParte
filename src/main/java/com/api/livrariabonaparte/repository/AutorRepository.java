package com.api.livrariabonaparte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.livrariabonaparte.model.Autor;


public interface AutorRepository extends JpaRepository<Autor, Long>{

}
