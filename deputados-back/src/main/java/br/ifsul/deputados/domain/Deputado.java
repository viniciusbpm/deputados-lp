package br.ifsul.deputados.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Deputado {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nome;
    private String siglaPartido;
    private String siglaUf;
    @OneToMany(mappedBy = "deputado")
    private List<Evento> eventos = new ArrayList<>();

    public void adicionarEvento(Evento evento){
        this.eventos.add(evento);
        evento.setDeputado(this);
    }
}
