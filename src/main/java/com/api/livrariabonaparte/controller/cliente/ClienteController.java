package com.api.livrariabonaparte.controller.cliente;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.livrariabonaparte.controller.cliente.request.ClienteRequest;
import com.api.livrariabonaparte.controller.cliente.response.ClienteResponse;
import com.api.livrariabonaparte.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@PostMapping("")
	public ResponseEntity<ClienteResponse> cadastro(@RequestBody @Validated ClienteRequest clienteRequest,
			UriComponentsBuilder uriBuilder) throws Exception {
		ClienteResponse cliente = clienteService.salvar(clienteRequest);
		URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(cliente);
	}

	@GetMapping("")
	public List<ClienteResponse> listar() {
		return clienteService.buscar();
	}

}
