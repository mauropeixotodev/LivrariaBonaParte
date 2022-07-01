package com.api.livrariabonaparte.controller.autor.request;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AutorRequest {
	
	private String nome;
	
	private String idade;

	private String nacionalidade;
	
	private String descricao;


}
