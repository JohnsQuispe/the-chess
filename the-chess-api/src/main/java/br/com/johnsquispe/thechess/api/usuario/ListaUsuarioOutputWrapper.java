package br.com.johnsquispe.thechess.api.usuario;

import br.com.johnsquispe.thechess.domain.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ListaUsuarioOutputWrapper {

    private final List<UsuarioOutput> usuarios;

    public ListaUsuarioOutputWrapper(List<UsuarioOutput> usuarios) {
        this.usuarios = usuarios;
    }

    public List<UsuarioOutput> getUsuarios() {
        return usuarios;
    }

    public static ListaUsuarioOutputWrapper of (List<Usuario> usuariosList) {
        final List<UsuarioOutput> usuarioOutputs = new ArrayList<>(usuariosList.size());
        for (Usuario usuario : usuariosList) {
            usuarioOutputs.add(UsuarioOutput.of(usuario));
        }

        return new ListaUsuarioOutputWrapper(usuarioOutputs);

    }

}
