package org.PerezAragon_Guillermo.apirest.dtos;

import java.util.Objects;

import lombok.Data;
import lombok.NonNull;

@Data
public class ClienteSinID {

	@NonNull
	private String nombre;
	private Integer tlf;
	
	public ClienteSinID() {
		this.nombre = "";
		this.tlf = 0;
	}
	
	public ClienteSinID(String nombre, Integer tlf) {
		this.nombre = nombre;
		this.tlf = tlf;
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


	@Override
	public String toString() {
		return "ClienteSinID [nombre=" + nombre + ", tlf=" + tlf + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(nombre, tlf);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteSinID other = (ClienteSinID) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(tlf, other.tlf);
	}
	
}
