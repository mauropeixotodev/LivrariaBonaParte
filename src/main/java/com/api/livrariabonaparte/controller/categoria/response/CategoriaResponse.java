package com.api.livrariabonaparte.controller.categoria.response;

import java.util.List;

import com.api.livrariabonaparte.controller.livro.response.LivroResponse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoriaResponse {

	private Long id;

	private String nome;

	private List<LivroResponse> livros;

}
