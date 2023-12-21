package br.ifsul.deputados.service;

import br.ifsul.deputados.controller.response.ApiDeputadoListResponse;
import br.ifsul.deputados.controller.response.ApiEventoListResponse;
import br.ifsul.deputados.controller.response.EventoResponse;
import br.ifsul.deputados.domain.Deputado;
import br.ifsul.deputados.mapper.DeputadoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarEventosService {
    public List<EventoResponse> listar(){
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ApiEventoListResponse> response = restTemplate
                .getForEntity("https://dadosabertos.camara.leg.br/api/v2/eventos", ApiEventoListResponse.class);

        return response.getBody().getDados();
    }
}
