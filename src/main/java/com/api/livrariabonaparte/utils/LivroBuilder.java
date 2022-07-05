package com.api.livrariabonaparte.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.livrariabonaparte.controller.livro.request.LivroRequest;
import com.api.livrariabonaparte.controller.livro.response.LivroResponse;
import com.api.livrariabonaparte.model.Autor;
import com.api.livrariabonaparte.model.Livro;

@Component
public class LivroBuilder {

	@Autowired
	AutorBuilder autorBuilder;

	@Autowired
	CategoriaBuilder categoriaBuilder;
		
	public List<LivroResponse> buildLivroResponse(List<Livro> livros) {

		return livros.stream().map(livro -> buildLivroResponse(livro)).collect(Collectors.toList());

	}

	public LivroResponse buildLivroResponse(Livro livro) {

		return LivroResponse.builder().id(livro.getId()).nome(livro.getNome()).download(livro.getDownload())
				.imagem(livro.getImagem()).autor(autorBuilder.autorResponseBuild(livro.getAutor())).categorias(categoriaBuilder.CategoriaResponseJustBuild(livro.getCategorias())).build();
	}

	public Livro buildLivro(LivroRequest livroRequest, Autor autor) {

		return Livro.builder().nome(livroRequest.getNome()).imagem(livroRequest.getImagem())
				.download(livroRequest.getDownload()).autor(autor)
				.categorias(categoriaBuilder.converter(livroRequest.getCategorias())).build();

	}

}