package br.gov.mt.pjc.srv.publico.repository;

import br.gov.mt.pjc.srv.publico.entity.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUnidadeRepository extends JpaRepository<Unidade, Integer> {
}
