package br.ifsul.deputados.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditarEventoRequest {
    @NotNull
    private Long idEvento;
    @NotBlank
    private String nome;
}
