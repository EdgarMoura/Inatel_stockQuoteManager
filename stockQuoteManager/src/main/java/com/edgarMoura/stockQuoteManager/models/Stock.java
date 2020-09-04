package com.edgarMoura.stockQuoteManager.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Stock {

	@Id
	@Column(unique = true)
	@NotEmpty(message = "Cant not be empty")
	@NotBlank(message = "Cant not be blank")
	private String id;
	
	@Column
	private String description;

	@Column
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
	private List<Quote> quotes;

}
