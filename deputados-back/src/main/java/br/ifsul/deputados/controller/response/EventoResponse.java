package br.ifsul.deputados.controller.response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventoResponse {
    private Long id;
    private String descricaoTipo;
}
