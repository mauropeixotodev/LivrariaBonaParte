package com.api.livrariabonaparte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.livrariabonaparte.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
