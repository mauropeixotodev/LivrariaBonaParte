package com.api.livrariabonaparte.controller.categoria;

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

import com.api.livrariabonaparte.controller.categoria.request.CategoriaRequest;
import com.api.livrariabonaparte.controller.categoria.response.CategoriaResponse;
import com.api.livrariabonaparte.controller.categoria.response.CategoriaResponseJust;
import com.api.livrariabonaparte.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;

	@PostMapping("")
	public ResponseEntity<CategoriaResponseJust> cadastro(@RequestBody @Validated CategoriaRequest categoriaRequest,
			UriComponentsBuilder uriBuilder) throws Exception {
		CategoriaResponseJust categoria = categoriaService.salvar(categoriaRequest);
		URI uri = uriBuilder.path("/categroia/{id}").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).body(categoria);
	}

	@GetMapping("")
	public List<CategoriaResponse> listar() {
		return categoriaService.buscar();
	}

}
