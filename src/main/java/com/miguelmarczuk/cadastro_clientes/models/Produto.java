package com.miguelmarczuk.cadastro_clientes.models;

import com.miguelmarczuk.cadastro_clientes.dto.ProdutoDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private double preco;
    private  int quantidadeEstoque;
    private String categoria;

    @ManyToMany
    private List<Cliente> clientes = new ArrayList<>();


    public Produto(ProdutoDTO dados , List<Cliente> clientes) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.preco = dados.preco();
        this.quantidadeEstoque = dados.quantidadeEstoque();
        this.categoria = dados.categoria();
        this.clientes = new ArrayList<>(clientes);
    }
}
