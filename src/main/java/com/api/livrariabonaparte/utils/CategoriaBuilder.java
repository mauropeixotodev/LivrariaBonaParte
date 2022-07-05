package com.api.livrariabonaparte.utils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.livrariabonaparte.controller.categoria.request.CategoriaRequest;
import com.api.livrariabonaparte.controller.categoria.request.CategoriaRequestId;
import com.api.livrariabonaparte.controller.categoria.response.CategoriaResponse;
import com.api.livrariabonaparte.controller.categoria.response.CategoriaResponseJust;
import com.api.livrariabonaparte.controller.livro.response.LivroResponse;
import com.api.livrariabonaparte.model.Categoria;
import com.api.livrariabonaparte.model.Livro;
import com.api.livrariabonaparte.repository.CategoriaRepository;


@Component
public class CategoriaBuilder {
	@Autowired
	AutorBuilder autorBuilder;

	@Autowired
	CategoriaRepository categoriaRepository;

	public Categoria categoriaBuild(CategoriaRequest categoriaRequest) {
		return Categoria.builder().nome(categoriaRequest.getNome()).build();
	}

	public CategoriaResponse categoriaResponseBuild(Categoria categoria) {
		return CategoriaResponse.builder().nome(categoria.getNome()).id(categoria.getId())
				.livros(buildLivroResponse(categoria.getLivros())).build();
	}
	public CategoriaResponseJust CategoriaResponseJustBuild(Categoria categoria) {
		return CategoriaResponseJust.builder().nome(categoria.getNome()).id(categoria.getId())
				.build();
	}

	public List<CategoriaResponseJust> CategoriaResponseJustBuild(List<Categoria> categorias) {
		return categorias.stream().map(categoria -> CategoriaResponseJustBuild(categoria)).toList();
	}


	public List<CategoriaResponse> categoriaResponseBuild(List<Categoria> categorias) {
		return categorias.stream().map(categoria -> categoriaResponseBuild(categoria)).toList();
	}

	public List<Categoria> converter(List<CategoriaRequestId> CategoriaRequestIds) {
		return CategoriaRequestIds.stream().map(categoriaId -> {
			try {
				return verifcar(categoriaId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}).toList();
	}

	private Categoria verifcar(CategoriaRequestId CategoriaRequestId) throws Exception {
		Optional<Categoria> categoriaOptinal = categoriaRepository.findById(CategoriaRequestId.getId());
		if (categoriaOptinal.isPresent()) {
			return categoriaOptinal.get();
		}
		throw new Exception("Categoria não existe!");
	}

	public List<LivroResponse> buildLivroResponse(List<Livro> livros) {

		return livros.stream().map(livro -> buildLivroResponse(livro)).collect(Collectors.toList());

	}

	public LivroResponse buildLivroResponse(Livro livro) {

		return LivroResponse.builder().id(livro.getId()).nome(livro.getNome()).download(livro.getDownload())
				.imagem(livro.getImagem()).autor(autorBuilder.autorResponseBuild(livro.getAutor())).categorias(CategoriaResponseJustBuild(livro.getCategorias())).build();
	}
}
