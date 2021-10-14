package org.PerezAragon_Guillermo.apirest.repositories;

import org.PerezAragon_Guillermo.apirest.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
}
