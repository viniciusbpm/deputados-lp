package br.ifsul.deputados.service;

import br.ifsul.deputados.controller.response.ApiDeputadoListResponse;
import br.ifsul.deputados.controller.response.DeputadoResponse;
import br.ifsul.deputados.mapper.DeputadoMapper;
import br.ifsul.deputados.repository.DeputadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarDeputadosService {
    @Autowired
    private DeputadoRepository deputadoRepository;

    public List<DeputadoResponse> listar(){
        return deputadoRepository.findAll().stream()
                .map(DeputadoMapper::toResponse)
                .collect(Collectors.toList());
    }
}
