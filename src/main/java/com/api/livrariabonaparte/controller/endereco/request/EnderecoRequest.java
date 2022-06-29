package com.api.livrariabonaparte.controller.endereco.request;



import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EnderecoRequest {
	
	private String numero;
 
	private String logradouro;
   
	private String complemento;

	private String bairro;

	private String referencia;

}
