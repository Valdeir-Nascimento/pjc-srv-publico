package br.gov.mt.pjc.srv.publico.repository;

import br.gov.mt.pjc.srv.publico.entity.ServidorEfetivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServidorEfetivoRepository extends JpaRepository<ServidorEfetivo, Integer> {
}
