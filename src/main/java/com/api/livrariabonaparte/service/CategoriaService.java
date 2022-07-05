package com.api.livrariabonaparte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.livrariabonaparte.controller.categoria.request.CategoriaRequest;
import com.api.livrariabonaparte.controller.categoria.response.CategoriaResponse;
import com.api.livrariabonaparte.controller.categoria.response.CategoriaResponseJust;
import com.api.livrariabonaparte.repository.CategoriaRepository;
import com.api.livrariabonaparte.utils.CategoriaBuilder;
@Service
public class CategoriaService {
	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	CategoriaBuilder categoriaBuilder;
	
	public CategoriaResponseJust salvar(CategoriaRequest categoriaRequest) {
		return categoriaBuilder.CategoriaResponseJustBuild(categoriaRepository.save(categoriaBuilder.categoriaBuild(categoriaRequest)));
	}

	public List<CategoriaResponse> buscar(){
		return categoriaBuilder.categoriaResponseBuild(categoriaRepository.findAll());
	}
	
	
	
}
