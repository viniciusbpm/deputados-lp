package br.ifsul.deputados.mapper;

import br.ifsul.deputados.controller.response.DeputadoResponse;
import br.ifsul.deputados.controller.response.EventoResponse;
import br.ifsul.deputados.domain.Deputado;
import br.ifsul.deputados.domain.Evento;

public class EventoMapper {
    public static Evento toEntity(EventoResponse eventoResponse){
        return Evento.builder()
                .id(eventoResponse.getId())
                .nome(eventoResponse.getDescricaoTipo())
                .build();
    }

    public static EventoResponse toResponse(Evento evento){
        return EventoResponse.builder()
                .id(evento.getId())
                .descricaoTipo(evento.getNome())
                .build();
    }
}
