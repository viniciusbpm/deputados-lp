package br.ifsul.deputados.repository;

import br.ifsul.deputados.domain.Deputado;
import br.ifsul.deputados.domain.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
