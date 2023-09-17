package br.gov.mt.pjc.srv.publico.mapper;

public interface IResponseMapper<T, R> {

    R toResponse(T entity);

}
