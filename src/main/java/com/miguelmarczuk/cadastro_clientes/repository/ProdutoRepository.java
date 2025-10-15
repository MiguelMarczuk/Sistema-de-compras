package com.miguelmarczuk.cadastro_clientes.repository;

import com.miguelmarczuk.cadastro_clientes.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto , Long> {
}
