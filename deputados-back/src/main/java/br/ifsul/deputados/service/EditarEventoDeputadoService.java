package br.ifsul.deputados.service;

import br.ifsul.deputados.controller.request.EditarEventoRequest;
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

import java.util.Optional;

import static br.ifsul.deputados.mapper.EventoMapper.toResponse;

@Service
public class EditarEventoDeputadoService {
    @Autowired
    private DeputadoRepository deputadoRepository;
    @Autowired
    private EventoRepository eventoRepository;

    public EventoResponse editar(Long idDeputado, EditarEventoRequest editarEventoRequest){
        Optional<Deputado> deputado = deputadoRepository.findById(idDeputado);

        if(deputado.isEmpty()){
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Deputado não encontrado");
        }

        Evento eventoASerEditado = eventoRepository.findById(editarEventoRequest.getIdEvento()).get();

        eventoASerEditado.setNome(editarEventoRequest.getNome());

        eventoRepository.save(eventoASerEditado);

        return toResponse(eventoASerEditado);
    }
}
