package br.ifsul.deputados.mapper;

import br.ifsul.deputados.controller.response.ApiDeputadoListResponse;
import br.ifsul.deputados.controller.response.DeputadoResponse;
import br.ifsul.deputados.domain.Deputado;

public class DeputadoMapper {
    public static Deputado toEntity(DeputadoResponse deputadoResponse){
        return Deputado.builder()
                .id(deputadoResponse.getId())
                .nome(deputadoResponse.getNome())
                .siglaUf(deputadoResponse.getSiglaUf())
                .siglaPartido(deputadoResponse.getSiglaPartido())
                .build();
    }

    public static DeputadoResponse toResponse(Deputado deputado){
        return DeputadoResponse.builder()
                .id(deputado.getId())
                .siglaUf(deputado.getSiglaUf())
                .siglaPartido(deputado.getSiglaPartido())
                .nome(deputado.getNome())
                .build();
    }
}
