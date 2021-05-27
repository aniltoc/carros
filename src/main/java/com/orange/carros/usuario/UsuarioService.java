package com.orange.carros.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //valida se já existe cpf ou email que foram informados cadastrados no banco
    public void validaUsuarioExistentePorCpfEEmail(String cpf, String email){
        if (usuarioRepository.existsByEmail(email)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Email já cadastrado");
        }
        if (usuarioRepository.existsByCpf(cpf)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"CPF já cadastrado");
        }
    }

    public void salvar(Usuario novoUsuario) {
        usuarioRepository.save(novoUsuario);
    }


}
