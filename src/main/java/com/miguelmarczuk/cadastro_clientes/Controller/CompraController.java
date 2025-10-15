package com.miguelmarczuk.cadastro_clientes.Controller;

import com.miguelmarczuk.cadastro_clientes.Service.CompraService;
import com.miguelmarczuk.cadastro_clientes.dto.CompraDTO;
import com.miguelmarczuk.cadastro_clientes.models.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("compra")
public class CompraController {

    @Autowired
    CompraService service;


    @PostMapping
    @Transactional
    public void compra(@RequestBody CompraDTO dados){
        service.criarCompra(dados);
    }

    @GetMapping
    public List<Compra> mostrarCompra(){
       return service.mostrarCompra();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarCompra(@PathVariable Long id){
        service.deletaCompra(id);
    }
}
