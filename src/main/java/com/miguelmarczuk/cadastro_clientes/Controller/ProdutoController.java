package com.miguelmarczuk.cadastro_clientes.Controller;

import com.miguelmarczuk.cadastro_clientes.dto.ProdutoDTO;
import com.miguelmarczuk.cadastro_clientes.models.Produto;
import com.miguelmarczuk.cadastro_clientes.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarProduto(@RequestBody @Validated ProdutoDTO dados){
        repository.save(new Produto(dados, new ArrayList<>()));
    }
     @GetMapping
    public List<Produto>listarProduto(){
        return repository.findAll();
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void deletarProduto(@PathVariable Long id){
        repository.deleteById(id);
    }
}
