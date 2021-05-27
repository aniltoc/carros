package com.orange.carros.carro;

import com.orange.carros.carro.marca.Marca;
import com.orange.carros.carro.marca.MarcaRepository;
import com.orange.carros.clients.*;
import com.orange.carros.usuario.Usuario;
import com.orange.carros.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private FipeClient fipeClient;

    public void salvar(Carro novoCarro) {
        carroRepository.save(novoCarro);
    }

    public Usuario buscaUsuarioPorId(Long usuarioId) {
       return usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

    }

    public FipeValorResponse buscaCarroCompletoFipe(NovoCarroRequest request) {
        Marca marca = marcaRepository.findByNome(request.getMarca())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Marca não encontrada"));
        String codigoMarca = marca.getCodigo();

        FipeModelosResponse fipeModelosResponse = fipeClient.buscaModelos(codigoMarca);
        List<ModelosResponse> modelos = fipeModelosResponse.getModelos();
        String modelo = request.getModelo();

        List<String> collect = modelos.stream().map(ModelosResponse::getNome).collect(Collectors.toList());

        if (!collect.contains(modelo)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Modelo não encontrado para essa marca");
        }

        Long codigoModelo = modelos.stream()
                .filter(m -> m.getNome().equals(modelo)).collect(Collectors.toList()).get(0).getCodigo();

        List<AnosResponse> anosResponse = fipeClient.buscaAnos(codigoMarca, codigoModelo);
        List<String> listaAnos = anosResponse.stream().map(AnosResponse::getNome).collect(Collectors.toList());

        if (!listaAnos.contains(request.getAno())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ano não encontrado para esse modelo");
        }

        String codigoAno = anosResponse.stream()
                .filter(a -> a.getNome().equals(request.getAno())).collect(Collectors.toList()).get(0).getCodigo();

        FipeValorResponse fipeValorResponse = fipeClient.buscaValor(codigoMarca, codigoModelo, codigoAno);
        System.out.println(codigoAno);
        return fipeClient.buscaValor(codigoMarca, codigoModelo, codigoAno);

    }

    //altero valor do rodizio ativo e devolvo uma lista de carros cadastrados para o usuario solicitado
    public List<Carro> buscaCarrosPorUsuarioId(Long usuarioId) {
        if(!usuarioRepository.existsById(usuarioId)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }
        List<Carro> listaCarros = carroRepository.findAllByUsuarioId(usuarioId);
        listaCarros.forEach(Carro::setDiaRodizio);
        return listaCarros;
    }
}
