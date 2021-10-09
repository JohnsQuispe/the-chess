package br.com.johnsquispe.thechess.api.usuario;

public class UsuarioUrls {

    public static final String USUARIO = "/api/usuario";
    public static final String USUARIO_DETALHE = "/api/usuario/{usuarioUuid}";
    public static final String USUARIO_CRIAR_TOKEN_RESET_SENHA = "/usuario/{usuarioUuid}/criar-token-reset-senha";

    private UsuarioUrls() {

    }

    public static class Params {

        public static final String USUARIO_UUID = "usuarioUuid";

        private Params() {

        }

    }

}
