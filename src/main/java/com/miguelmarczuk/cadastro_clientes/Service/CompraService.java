package com.miguelmarczuk.cadastro_clientes.Service;

import com.miguelmarczuk.cadastro_clientes.dto.CompraDTO;
import com.miguelmarczuk.cadastro_clientes.models.Cliente;
import com.miguelmarczuk.cadastro_clientes.models.Compra;
import com.miguelmarczuk.cadastro_clientes.models.Produto;
import com.miguelmarczuk.cadastro_clientes.repository.ClienteRepository;
import com.miguelmarczuk.cadastro_clientes.repository.CompraRepository;
import com.miguelmarczuk.cadastro_clientes.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CompraService {
    @Autowired
    CompraRepository compraRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    public void criarCompra(@RequestBody CompraDTO dados){
        Cliente cliente = clienteRepository.findById(dados.clienteId())
                .orElseThrow(() -> new RuntimeException("cliente nao encontrado"));

        Produto produto = produtoRepository.findById(dados.produtoId())
                .orElseThrow(() -> new RuntimeException("Produto nao encontrado"));

        if (cliente.getSaldo() >= produto.getPreco() * dados.quantidade()){
            cliente.setSaldo(cliente.getSaldo() - (produto.getPreco() * dados.quantidade()) );
            System.out.println("saldo" + cliente.getSaldo());
            System.out.println("quandidade pedida" + dados.quantidade());

            clienteRepository.save(cliente);
        }else {
            throw new RuntimeException("saldo insuficiente");
        }

        if (produto.getQuantidadeEstoque() >= dados.quantidade() ){



          produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - dados.quantidade());
            produtoRepository.save(produto);

        Compra compra = new Compra(cliente , produto, dados.quantidade());
        compraRepository.save(compra);


        }else {
            throw new RuntimeException("Estoque insuficiente");
        }
    }


    public List<Compra> mostrarCompra(){
       return compraRepository.findAll();
    }

    public void  deletaCompra(@RequestParam Long id){

         Compra compra = compraRepository.findById(id).orElseThrow(() -> new RuntimeException("Compra nao encontrada"));

         Produto produto = compra.getProduto();

         Cliente cliente = compra.getCliente();

           produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + compra.getQuantidade() );
         cliente.setSaldo(cliente.getSaldo() + produto.getPreco()  * compra.getQuantidade());

       produtoRepository.save(produto);
        compraRepository.deleteById(id);
    }





}
