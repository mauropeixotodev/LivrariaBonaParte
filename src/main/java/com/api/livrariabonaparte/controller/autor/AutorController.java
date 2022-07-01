package com.api.livrariabonaparte.controller.autor;

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

import com.api.livrariabonaparte.controller.autor.request.AutorRequest;
import com.api.livrariabonaparte.controller.autor.response.AutorResponse;
import com.api.livrariabonaparte.service.AutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	AutorService autorService;

	@PostMapping("")
	public ResponseEntity<AutorResponse> cadastro(@RequestBody @Validated AutorRequest autorRequest,
			UriComponentsBuilder uriBuilder) throws Exception {
		AutorResponse autor = autorService.salvar(autorRequest);
		URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(autor.getId()).toUri();
		return ResponseEntity.created(uri).body(autor);
	}

	@GetMapping("")
	public List<AutorResponse> listar() {
		return autorService.buscar();
	}

}
