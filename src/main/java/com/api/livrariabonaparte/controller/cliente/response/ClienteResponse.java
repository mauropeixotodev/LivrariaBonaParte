package com.api.livrariabonaparte.controller.cliente.response;

import com.api.livrariabonaparte.controller.endereco.response.EnderecoResponse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteResponse {
	
	private Long id;

	private String nome;

	private EnderecoResponse endereco;
}
