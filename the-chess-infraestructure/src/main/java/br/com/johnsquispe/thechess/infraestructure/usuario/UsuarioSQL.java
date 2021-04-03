package br.com.johnsquispe.thechess.infraestructure.usuario;

public class UsuarioSQL {

    public static final String SELECT_USUARIO = new StringBuilder()
                            .append("SELECT ")
                            .append(    "USUARIO.ID AS \"USUARIO.ID\", ")
                            .append(    "USUARIO.NICKNAME AS \"USUARIO.NICKNAME\", ")
                            .append(    "USUARIO.EMAIL AS \"USUARIO.EMAIL\", ")
                            .append(    "USUARIO.SENHA AS \"USUARIO.SENHA\", ")
                            .append(    "USUARIO.DATA_CRIACAO AS \"USUARIO.DATA_CRIACAO\", ")
                            .append(    "USUARIO.DATA_EXCLUSAO AS \"USUARIO.DATA_EXCLUSAO\", ")
                            .append(    "USUARIO.DATA_INATIVACAO AS \"USUARIO.DATA_INATIVACAO\", ")
                            .append(    "USUARIO.TIPO_CONTA AS \"USUARIO.TIPO_CONTA\" ")
                            .append("FROM ")
                            .append(    "THECHESS.USUARIO ")
                            .append("WHERE ")
                            .append(    "USUARIO.DATA_EXCLUSAO IS NULL; ").toString();
}