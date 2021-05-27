package com.orange.carros.carro;

import com.orange.carros.clients.FipeValorResponse;
import com.orange.carros.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping("/usuario/{usuarioId}")
    public ResponseEntity<String> cadastra(@PathVariable Long usuarioId, @RequestBody @Valid NovoCarroRequest request){
       Usuario usuario = carroService.buscaUsuarioPorId(usuarioId);

        FipeValorResponse fipeResponse = carroService.buscaCarroCompletoFipe(request);

        System.out.println(fipeResponse.toString());
        Carro novoCarro = request.toModel(usuario, fipeResponse);

        carroService.salvar(novoCarro);

        return ResponseEntity.status(201).body("Carro cadastrado");
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<CarroResponse>> listaCarrosParaUmUsuario(@PathVariable Long usuarioId){
        List<Carro> listaCarros = carroService.buscaCarrosPorUsuarioId(usuarioId);

        List<CarroResponse> carrosResponse = listaCarros.stream().map(CarroResponse::new).collect(Collectors.toList());

        return ResponseEntity.status(200).body(carrosResponse);



    }

}
