package br.ifsul.deputados.service;

import br.ifsul.deputados.controller.response.ApiDeputadoListResponse;
import br.ifsul.deputados.domain.Deputado;
import br.ifsul.deputados.mapper.DeputadoMapper;
import br.ifsul.deputados.repository.DeputadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PopularBancoDeputadosService {
    @Autowired
    private DeputadoRepository deputadoRepository;

    public void popular(){

        if(deputadoRepository.count() > 0) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Esta tabela já está populada.");
        }

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ApiDeputadoListResponse> response = restTemplate
                .getForEntity("https://dadosabertos.camara.leg.br/api/v2/deputados", ApiDeputadoListResponse.class);
        List<Deputado> deputados = response.getBody().getDados().stream().map(DeputadoMapper::toEntity).toList();

        deputadoRepository.saveAll(deputados);
    }
}
