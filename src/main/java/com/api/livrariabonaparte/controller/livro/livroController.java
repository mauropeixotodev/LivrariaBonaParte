package com.api.livrariabonaparte.controller.livro;

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

import com.api.livrariabonaparte.controller.livro.request.LivroRequest;
import com.api.livrariabonaparte.controller.livro.response.LivroResponse;
import com.api.livrariabonaparte.service.LivroService;

@RestController
@RequestMapping("/livro")
public class livroController {

	@Autowired
	LivroService livroService;

	@PostMapping("")
	public ResponseEntity<LivroResponse> cadastro(@RequestBody @Validated LivroRequest livroRequest,
			UriComponentsBuilder uriBuilder) throws Exception {
		LivroResponse livro = livroService.salvar(livroRequest);
		URI uri = uriBuilder.path("/livro/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri).body(livro);
	}

	@GetMapping("")
	public List<LivroResponse> listar() {
		return livroService.buscar();
	}

}
