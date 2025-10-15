package com.miguelmarczuk.cadastro_clientes.models;

import com.miguelmarczuk.cadastro_clientes.dto.EnderecoDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco{
 private String logradouro;
         private  String numero;
                 private  String complemento;
                    private  String bairro;
                      private String cidade;
                      private String estado;
                    private    String cep;

    public Endereco(EnderecoDTO dados) {
        this.logradouro = dados.logradouro();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.bairro = dados.bairro();
        this.cidade = dados.cidade();
        this.estado = dados.estado();
        this.cep = dados.cep();
    }



}
