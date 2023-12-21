package br.ifsul.deputados.repository;

import br.ifsul.deputados.domain.Deputado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeputadoRepository extends JpaRepository<Deputado, Long> {
}
