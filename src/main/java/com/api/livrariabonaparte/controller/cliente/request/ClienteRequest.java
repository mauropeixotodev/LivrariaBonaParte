package com.api.livrariabonaparte.controller.cliente.request;

import com.api.livrariabonaparte.controller.endereco.request.EnderecoRequest;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ClienteRequest {
	
	private String nome;
	
	private EnderecoRequest endereco;

}
