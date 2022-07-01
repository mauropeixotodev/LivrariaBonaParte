package com.api.livrariabonaparte.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.livrariabonaparte.controller.autor.request.AutorRequest;
import com.api.livrariabonaparte.controller.autor.response.AutorResponse;
import com.api.livrariabonaparte.model.Autor;

@Component
public class AutorBuilder {

	public Autor autorBuild(AutorRequest autorRequest) {
		return Autor.builder().nome(autorRequest.getNome()).idade(autorRequest.getIdade())
				.descricao(autorRequest.getDescricao()).nacionalidade(autorRequest.getNacionalidade()).build();
	}

	public AutorResponse autorResponseBuild(Autor autor) {
		return AutorResponse.builder().id(autor.getId()).nome(autor.getNome()).nacionalidade(autor.getNacionalidade())
				.descricao(autor.getDescricao()).idade(autor.getIdade()).build();
	}
	
	public List<AutorResponse> autorResponseBuild(List<Autor> autores){
		return autores.stream().map(autor -> autorResponseBuild(autor)).collect(Collectors.toList());
	}

}
