package com.api.livrariabonaparte.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livro_seq")
	@SequenceGenerator(name = "livro_seq", sequenceName = "livro_seq", allocationSize = 1)
	@EqualsAndHashCode.Include
	private Long id;
	@Column(nullable = false)
	private String imagem;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String download;
	@ManyToOne
	@JoinColumn(name = "autor_id", referencedColumnName = "id")
	private Autor autor;

}
