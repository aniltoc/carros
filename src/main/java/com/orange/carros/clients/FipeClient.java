package com.orange.carros.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "FIPE", url = "https://parallelum.com.br/fipe/api/v1")
public interface FipeClient {

    @GetMapping("/carros/marcas")
    List<FipeMarcasResponse> buscaMarcas();

    @GetMapping("/carros/marcas/{codigo}/modelos")
    FipeModelosResponse buscaModelos(@PathVariable String codigo);

    @GetMapping("/carros/marcas/{codigoMarca}/modelos/{codigoModelo}/anos")
    List<AnosResponse> buscaAnos(@PathVariable String codigoMarca, @PathVariable Long codigoModelo);

    @GetMapping("/carros/marcas/{codigoMarca}/modelos/{codigoModelo}/anos/{codigoAno}")
    FipeValorResponse buscaValor(@PathVariable String codigoMarca,
                                 @PathVariable Long codigoModelo,
                                 @PathVariable String codigoAno);

}
