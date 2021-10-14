package org.PerezAragon_Guillermo.apirest.services;

import java.util.List;
import java.util.Optional;

import org.PerezAragon_Guillermo.apirest.Models.Cliente;
import org.PerezAragon_Guillermo.apirest.dtos.ClienteSinID;
import org.PerezAragon_Guillermo.apirest.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository cr;
	
	public List<Cliente> findAll() {
		return cr.findAll();
	}
	
	public Cliente save(ClienteSinID cliente) {
		Cliente c = new Cliente(null, cliente.getNombre(), cliente.getTlf());
		return cr.save(c);
	}
	
	public Optional<Cliente> findById(Long id) {
		return cr.findById(id);
	}
	
	public void deleteById(Long id) {
        cr.deleteById(id);
    }
	
	public Cliente update(Cliente c) {
        return cr.save(c);
    }
}
