package br.gov.mt.pjc.srv.publico.mapper;

public interface ICopiaPropriedades<T, S> {

    void copiar(S source, T entity);

}
