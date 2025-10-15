package com.miguelmarczuk.cadastro_clientes.dto;

import com.miguelmarczuk.cadastro_clientes.models.Cliente;
import com.miguelmarczuk.cadastro_clientes.models.Produto;

public record CompraDTO( Long clienteId,

          Long produtoId,
          int quantidade) {
}
