package com.miguelmarczuk.cadastro_clientes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ClienteDTO(Long id,
                         @NotBlank
                         String nome,
                         @NotNull
                         double saldo,
                         @NotBlank
                         @Email
                         String email,
                         String dataNascimento,
                         @NotNull
                         EnderecoDTO endereco,
                         Date dataCadastro) {


}
