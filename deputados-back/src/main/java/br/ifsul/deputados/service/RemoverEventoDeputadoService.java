package br.ifsul.deputados.service;

import br.ifsul.deputados.controller.response.EventoResponse;
import br.ifsul.deputados.domain.Deputado;
import br.ifsul.deputados.domain.Evento;
import br.ifsul.deputados.mapper.EventoMapper;
import br.ifsul.deputados.repository.DeputadoRepository;
import br.ifsul.deputados.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RemoverEventoDeputadoService {
    @Autowired
    private DeputadoRepository deputadoRepository;
    @Autowired
    private EventoRepository eventoRepository;

    public void remover(Long idDeputado, Long idEvento){
        Optional<Deputado> deputado = deputadoRepository.findById(idDeputado);

        if(deputado.isEmpty()){
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Deputado não encontrado");
        }

        Evento eventoASerRemovido = eventoRepository.findById(idEvento).get();

        eventoRepository.delete(eventoASerRemovido);
    }
}
