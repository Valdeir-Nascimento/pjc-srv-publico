package br.gov.mt.pjc.srv.publico.exception.handler;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class Field {

	private String name;
	private String userMessage;

}