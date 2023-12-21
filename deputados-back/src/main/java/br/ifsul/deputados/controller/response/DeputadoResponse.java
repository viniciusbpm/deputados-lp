package br.ifsul.deputados.controller.response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeputadoResponse {
    private Long id;
    private String nome;
    private String siglaPartido;
    private String siglaUf;
}
