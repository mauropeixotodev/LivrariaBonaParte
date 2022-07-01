package com.api.livrariabonaparte.controller.livro.response;


import com.api.livrariabonaparte.controller.autor.response.AutorResponse;

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

}
