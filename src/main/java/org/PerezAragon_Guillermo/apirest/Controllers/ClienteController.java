package org.PerezAragon_Guillermo.apirest.Controllers;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.PerezAragon_Guillermo.apirest.Models.Cliente;
import org.PerezAragon_Guillermo.apirest.dtos.ClienteDTO;
import org.PerezAragon_Guillermo.apirest.dtos.ClienteSinID;
import org.PerezAragon_Guillermo.apirest.dtos.ClientesListDTO;
import org.PerezAragon_Guillermo.apirest.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
	@Autowired
	private ClienteService cs;
	
	@GetMapping("/api/clientes")
	public ClientesListDTO getAll() {
		List<Cliente> listado = cs.findAll();
		try {
			return new ClientesListDTO(null, listado, "");
		} catch (NoSuchElementException nsee) {
			return new ClientesListDTO(null, null, "Ha habido un problema con la BBDD");
		}
	}
	
	@PostMapping("/api/clientes")
	public ClienteDTO postCliente(@RequestBody @Valid ClienteSinID clienteSinId) {
		try {
			Cliente c = cs.save(clienteSinId);
			return new ClienteDTO(false, c, "");
		} catch (NoSuchElementException nsee) {
			return new ClienteDTO(true, null, "Problema al añadir al cliente");
		}
	}
	
	@GetMapping("/api/clientes/{id}")
	public ClienteDTO getByID(@PathVariable Long id){
        try {
            Cliente c = cs.findById(id).get();
            return new ClienteDTO(false, c, "");
        }catch (NoSuchElementException nsee) {
            return new ClienteDTO(true, null, "Cliente no encontrado");
        }
    }
	
	@PutMapping("/api/clientes/{id}")
    public ClienteDTO updateById(@PathVariable Long id, @RequestBody @Valid Cliente clienteModificado){
        try {
            Cliente c = cs.findById(id).get();
            c.setNombre(clienteModificado.getNombre());
            c.setTlf(clienteModificado.getTlf());
            cs.update(c);
            return new ClienteDTO(false, c, "");
        }catch (NoSuchElementException nsee) {
            return new ClienteDTO(true, null, "Cliente no encontrado");
        }
    }
	
	@DeleteMapping("/api/clientes/{id}")
    public ClienteDTO deleteByID(@PathVariable Long id){
        try {
            Cliente c = cs.findById(id).get();
            cs.deleteById(id);
            return new ClienteDTO(false, c, "");
        }catch (NoSuchElementException nsee) {
            return new ClienteDTO(true, null, "Cliente no encontrado");
        }
    }
}
