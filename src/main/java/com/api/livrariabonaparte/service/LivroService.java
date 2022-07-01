package com.api.livrariabonaparte.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.livrariabonaparte.controller.livro.request.LivroRequest;
import com.api.livrariabonaparte.controller.livro.response.LivroResponse;
import com.api.livrariabonaparte.model.Autor;
import com.api.livrariabonaparte.repository.AutorRepository;
import com.api.livrariabonaparte.repository.LivroRepository;
import com.api.livrariabonaparte.utils.LivroBuilder;

@Service
public class LivroService {

	@Autowired
	LivroBuilder livroBuilder;

	@Autowired
	LivroRepository livroRepository;

	@Autowired
	AutorRepository autorRepository;

	public LivroResponse salvar(LivroRequest livroRequest) throws Exception {
		Optional<Autor> autorOptional = autorRepository.findById(livroRequest.getAutor().getId());
		if (autorOptional.isPresent()) {
			return livroBuilder.buildLivroResponse(
					livroRepository.save(livroBuilder.buildLivro(livroRequest, autorOptional.get())));
		}
		throw new Exception("Autor não existente!");
	}

	public List<LivroResponse> buscar() {
		return livroBuilder.buildLivroResponse(livroRepository.findAll());
	}

}
