package com.api.livrariabonaparte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.livrariabonaparte.controller.autor.request.AutorRequest;
import com.api.livrariabonaparte.controller.autor.response.AutorResponse;
import com.api.livrariabonaparte.repository.AutorRepository;
import com.api.livrariabonaparte.utils.AutorBuilder;
@Service
public class AutorService {
	@Autowired
	AutorBuilder autorBuilder;
	@Autowired
	AutorRepository autorRepository;

	public AutorResponse salvar(AutorRequest autorRequest) {
		return autorBuilder.autorResponseBuild(autorRepository.save(autorBuilder.autorBuild(autorRequest)));
	}

	public List<AutorResponse> buscar(){
	return autorBuilder.autorResponseBuild(autorRepository.findAll());

	}

}
