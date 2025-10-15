package com.miguelmarczuk.cadastro_clientes.dto;

public record EnderecoDTO( String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep) {
}
