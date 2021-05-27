package com.orange.carros.carro.marca;

import com.orange.carros.clients.FipeClient;
import com.orange.carros.clients.FipeMarcasResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usounico")
public class usounicoController {

    @Autowired
    private FipeClient fipeClient;

    @Autowired
    private MarcaRepository marcaRepository;

    @GetMapping
    public void cadastra (){
        List<FipeMarcasResponse> response = fipeClient.buscaMarcas();
        List<Marca> marcas= response.stream().map(m-> new Marca(m.getNome(), m.getCodigo())).collect(Collectors.toList());
        marcaRepository.saveAll(marcas);

    }

}
