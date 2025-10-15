package com.miguelmarczuk.cadastro_clientes.dto;

import com.miguelmarczuk.cadastro_clientes.models.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record ProdutoDTO(


        @NotBlank
        String nome,
         String descricao,
         @NotNull
         @Positive
         double preco,
          int quantidadeEstoque,
        String categoria,
         List<Long> clienteIds) {
}
