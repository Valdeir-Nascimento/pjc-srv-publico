package br.gov.mt.pjc.srv.publico.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ConstantesUtil {
    public static final String MSG_REGISTRO_NAO_ENCONTRADO = "Registro de código %d não foi encontrado";
    public static final String FAZENDA_NAO_ENCONTRADA_EXCEPTION = "Não foi encontrado cadastro de fazendo com Id: %d";
    public static final String MSG_ERRO_GENERICA_USUARIO_FINAL =
            "Ocorreu um erro interno inesperado no sistema," +
                    " tente novamente mais tarde, " + "e se problema persistir," +
                    " entre em contato com o administrador do sistema.";
    public static final String MSG_DADOS_INVALIDOS = "Um ou mais campos estão inválidos. " +
            "Faça o preenchimento correto e tente novamente.";

}