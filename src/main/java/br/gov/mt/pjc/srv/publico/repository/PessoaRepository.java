package br.gov.mt.pjc.srv.publico.repository;

import br.gov.mt.pjc.srv.publico.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
