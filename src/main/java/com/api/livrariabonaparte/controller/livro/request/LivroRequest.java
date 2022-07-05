package com.api.livrariabonaparte.controller.livro.request;

import java.util.List;

import com.api.livrariabonaparte.controller.autor.request.AutorRequestId;
import com.api.livrariabonaparte.controller.categoria.request.CategoriaRequestId;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LivroRequest {

	private String imagem;

	private String nome;

	private String download;

	private AutorRequestId autor;
	
	private List<CategoriaRequestId> categorias;

}
