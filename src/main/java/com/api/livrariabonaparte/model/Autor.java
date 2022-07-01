package com.api.livrariabonaparte.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "autor_seq")
	@SequenceGenerator(name = "autor_seq", sequenceName = "autor_seq", allocationSize = 1)
	@EqualsAndHashCode.Include
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String idade;
	@Column(nullable = false)
	private String nacionalidade;
	@Column(nullable = false)
	private String descricao;
	@OneToMany(mappedBy = "autor")
	private List<Livro> livros;

}
