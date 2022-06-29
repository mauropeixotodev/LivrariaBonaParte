package com.api.livrariabonaparte.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.livrariabonaparte.controller.cliente.request.ClienteRequest;
import com.api.livrariabonaparte.controller.cliente.response.ClienteResponse;
import com.api.livrariabonaparte.controller.endereco.request.EnderecoRequest;
import com.api.livrariabonaparte.controller.endereco.response.EnderecoResponse;
import com.api.livrariabonaparte.model.Cliente;
import com.api.livrariabonaparte.model.Endereco;

@Component
public class ClienteBuilder {
	

	public List<ClienteResponse> buildClienteResponse(List<Cliente> clientes) {

		return clientes.stream().map(cliente -> buildClienteResponse(cliente)).collect(Collectors.toList());
	}

	public ClienteResponse buildClienteResponse(Cliente cliente) {
		return ClienteResponse.builder().id(cliente.getId()).nome(cliente.getNome())
				.endereco(buildEnderecoResponse(cliente.getEndereco())).build();
	}

	public EnderecoResponse buildEnderecoResponse(Endereco endereco) {
		return EnderecoResponse.builder().bairro(endereco.getBairro()).complemento(endereco.getComplemento())
				.id(endereco.getId()).logradouro(endereco.getLogradouro()).numero(endereco.getNumero())
				.referencia(endereco.getReferencia()).build();

	}

	public Cliente buildClient(ClienteRequest clientRequest) {
		return Cliente.builder().nome(clientRequest.getNome()).endereco(buildEndereco(clientRequest.getEndereco()))
				.build();
	}

	public Endereco buildEndereco(EnderecoRequest enderecoRequest) {
		return Endereco.builder().bairro(enderecoRequest.getBairro()).complemento(enderecoRequest.getComplemento())
				.logradouro(enderecoRequest.getLogradouro()).numero(enderecoRequest.getNumero())
				.referencia(enderecoRequest.getReferencia()).build();
	}


}
