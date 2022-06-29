package com.api.livrariabonaparte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.livrariabonaparte.controller.cliente.request.ClienteRequest;
import com.api.livrariabonaparte.controller.cliente.response.ClienteResponse;
import com.api.livrariabonaparte.repository.ClienteRepository;
import com.api.livrariabonaparte.utils.ClienteBuilder;

@Service
public class ClienteService {

	@Autowired
	ClienteBuilder clienteBuilder;

	@Autowired
	ClienteRepository clienteRepository;

	public ClienteResponse salvar(ClienteRequest clienteRequest) {
		return clienteBuilder.buildClienteResponse(clienteRepository.save(clienteBuilder.buildClient(clienteRequest)));
	}

	public List<ClienteResponse> buscar() {
		return clienteBuilder.buildClienteResponse(clienteRepository.findAll());

	}

}
