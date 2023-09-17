package br.gov.mt.pjc.srv.publico.repository;

import br.gov.mt.pjc.srv.publico.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPessoaRepository extends JpaRepository<Pessoa, Integer> {

}
