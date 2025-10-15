package com.miguelmarczuk.cadastro_clientes.repository;

import com.miguelmarczuk.cadastro_clientes.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente , Long> {
}
