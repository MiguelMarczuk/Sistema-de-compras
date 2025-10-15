package com.miguelmarczuk.cadastro_clientes.models;

import com.miguelmarczuk.cadastro_clientes.dto.ClienteDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private   String nome;
        private  double saldo;
        private  String email;
        private String dataNascimento;
        @Embedded
        private Endereco endereco;
        private  Date dataCadastro;
        @ManyToMany(mappedBy = "clientes")
       private List<Produto> produtos = new ArrayList<>();

    public Cliente(ClienteDTO dados) {

        this.nome = dados.nome();
        this.saldo = dados.saldo();
        this.email = dados.email();
        this.dataNascimento = dados.dataNascimento();
        this.endereco = new Endereco(dados.endereco());
        this.dataCadastro = new Date();
    }


    public void atualizarInformacoes(ClienteDTO dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.email() != null){
            this.email = dados.email();
        }


    }
}
