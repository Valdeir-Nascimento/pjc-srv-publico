package br.gov.mt.pjc.srv.publico.mapper;

import java.util.List;

public interface IBaseMapper<T, S, R> {

    T toEntity(S request);
    R toResponse(T entity);
    List<R> toList(List<T> entities);
    T toConvert(R response);

}
