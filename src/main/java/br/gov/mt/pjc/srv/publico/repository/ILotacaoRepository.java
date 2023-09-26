package br.gov.mt.pjc.srv.publico.repository;

import br.gov.mt.pjc.srv.publico.entity.Lotacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILotacaoRepository extends JpaRepository<Lotacao, Integer> {
}
