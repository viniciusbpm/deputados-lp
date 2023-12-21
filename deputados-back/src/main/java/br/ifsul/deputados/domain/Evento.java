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
public class Evento {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "deputado_id")
    private Deputado deputado;
}
