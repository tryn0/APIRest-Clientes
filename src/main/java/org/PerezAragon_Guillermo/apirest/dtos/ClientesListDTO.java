package org.PerezAragon_Guillermo.apirest.dtos;

import java.util.List;

import org.PerezAragon_Guillermo.apirest.Models.Cliente;

import lombok.Data;

@Data
public class ClientesListDTO {
	private Boolean errors;
	private List<Cliente> data;
	private String message;
	
	public ClientesListDTO(Boolean errors, List<Cliente> data, String message) {
		this.errors = errors;
		this.data = data;
		this.message = message;
	}
}