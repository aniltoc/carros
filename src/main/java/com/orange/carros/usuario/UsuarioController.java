package com.orange.carros.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid NovoUsuarioRequest request){
        //valida se ja existe cpf ou email que foram informados cadastrados no banco
        usuarioService.validaUsuarioExistentePorCpfEEmail(request.getCpf(), request.getEmail());

        Usuario novoUsuario = request.toModel();
        usuarioService.salvar(novoUsuario);

        return ResponseEntity.status(201).build();

    }


}
