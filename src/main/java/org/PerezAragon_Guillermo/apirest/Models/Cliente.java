package org.PerezAragon_Guillermo.apirest.Models;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
	private Long id;
	@NonNull
	private String nombre;
	private Integer tlf;
	
	public Cliente() {
		this.id = 0L;
		this.nombre = "";
		this.tlf = 0;
	}
	
	public Cliente(Long id, String nombre, Integer tlf) {
		this.id = id;
		this.nombre = nombre;
		this.tlf = tlf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTlf() {
		return tlf;
	}

	public void setTlf(Integer tlf) {
		this.tlf = tlf;
	}
}
