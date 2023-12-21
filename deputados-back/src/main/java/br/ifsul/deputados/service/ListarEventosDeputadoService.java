package br.ifsul.deputados.service;

import br.ifsul.deputados.controller.response.ApiEventoListResponse;
import br.ifsul.deputados.controller.response.EventoResponse;
import br.ifsul.deputados.domain.Deputado;
import br.ifsul.deputados.mapper.EventoMapper;
import br.ifsul.deputados.repository.DeputadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ListarEventosDeputadoService {
    @Autowired
    private DeputadoRepository deputadoRepository;

    public List<EventoResponse> listarDoDeputado(Long idDeputado){
        Optional<Deputado> deputado = deputadoRepository.findById(idDeputado);

        if(deputado.isEmpty()){
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Deputado não encontrado");
        }

        return deputado.get().getEventos().stream().map(EventoMapper::toResponse).collect(Collectors.toList());
    }
}
