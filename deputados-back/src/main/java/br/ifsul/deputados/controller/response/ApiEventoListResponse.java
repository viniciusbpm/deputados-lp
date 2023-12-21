package br.ifsul.deputados.controller.response;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiEventoListResponse {
    private List<EventoResponse> dados;
}
