package com.miguelmarczuk.cadastro_clientes.Controller;


import com.miguelmarczuk.cadastro_clientes.dto.ClienteDTO;
import com.miguelmarczuk.cadastro_clientes.models.Cliente;
import com.miguelmarczuk.cadastro_clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    ClienteRepository repository;

     @PostMapping
     @Transactional
    public void cadastroCliente(@RequestBody @Validated ClienteDTO dados){
        repository.save(new Cliente(dados));
     }
     @GetMapping
    public List<Cliente> listarClientes(){
         return  repository.findAll();
     }

     @PutMapping
     @Transactional
     public void atualizarcliente(@RequestBody @Validated ClienteDTO dados){
         var cliente = repository.getReferenceById(dados.id());
         cliente.atualizarInformacoes(dados);

     }
     

     @DeleteMapping("/{id}")
     @Transactional
    public void deleterCliente(@PathVariable Long id){
         repository.deleteById(id);

     }

}
