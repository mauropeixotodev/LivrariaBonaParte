package com.api.livrariabonaparte.controller.livro.response;


import java.util.List;

import com.api.livrariabonaparte.controller.autor.response.AutorResponse;
import com.api.livrariabonaparte.controller.categoria.response.CategoriaResponse;
import com.api.livrariabonaparte.controller.categoria.response.CategoriaResponseJust;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class LivroResponse {
	
	private Long id;
	
	private String imagem;

	private String nome;

	private String download;

	private AutorResponse autor;
	
	private List<CategoriaResponseJust> categorias;

}
