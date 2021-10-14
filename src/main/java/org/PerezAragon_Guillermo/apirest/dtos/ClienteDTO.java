package org.PerezAragon_Guillermo.apirest.dtos;

import org.PerezAragon_Guillermo.apirest.Models.Cliente;

import lombok.Data;

@Data
public class ClienteDTO {
	private Boolean errors;
	private Cliente data;
	private String message;
	
	public ClienteDTO(Boolean errors, Cliente data, String message) {
		this.errors = errors;
		this.data = data;
		this.message = message;
	}
	
	
}
