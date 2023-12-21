package br.ifsul.deputados.service;

import br.ifsul.deputados.controller.response.ApiEventoListResponse;
import br.ifsul.deputados.controller.response.ApiEventoResponse;
import br.ifsul.deputados.domain.Deputado;
import br.ifsul.deputados.domain.Evento;
import br.ifsul.deputados.mapper.EventoMapper;
import br.ifsul.deputados.repository.DeputadoRepository;
import br.ifsul.deputados.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class InscreverDeputadoEventoService {
    @Autowired
    private DeputadoRepository deputadoRepository;
    @Autowired
    private EventoRepository eventoRepository;
    public void inscrever(Long idDeputado, Long idEvento){
        Optional<Deputado> deputado = deputadoRepository.findById(idDeputado);

        if(deputado.isEmpty()){
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Deputado não encontrado");
        }

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ApiEventoResponse> response = restTemplate
                .getForEntity("https://dadosabertos.camara.leg.br/api/v2/eventos/" + idEvento, ApiEventoResponse.class);

        Evento evento = EventoMapper.toEntity(response.getBody().getDados());

        deputado.get().adicionarEvento(evento);

        eventoRepository.save(evento);
    }
}
