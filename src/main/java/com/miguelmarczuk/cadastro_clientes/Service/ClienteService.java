package com.miguelmarczuk.cadastro_clientes.Service;

import com.miguelmarczuk.cadastro_clientes.dto.ClienteDTO;
import com.miguelmarczuk.cadastro_clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;





}
