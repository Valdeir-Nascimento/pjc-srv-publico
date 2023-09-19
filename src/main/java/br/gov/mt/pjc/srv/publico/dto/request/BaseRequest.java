package br.gov.mt.pjc.srv.publico.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseRequest {

    @NotNull
    @Positive
    private Integer id;

}
