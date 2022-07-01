package com.api.livrariabonaparte.controller.livro.request;

import com.api.livrariabonaparte.controller.autor.request.AutorRequestId;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LivroRequest {

	private String imagem;

	private String nome;

	private String download;

	private AutorRequestId autor;

}
