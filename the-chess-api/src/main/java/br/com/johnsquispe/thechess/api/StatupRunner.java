package br.com.johnsquispe.thechess.api;

import br.com.johnsquispe.thechess.domain.logger.ApplicationLogger;
import br.com.johnsquispe.thechess.domain.usuario.Usuario;
import br.com.johnsquispe.thechess.domain.usuario.UsuarioBuscaService;
import br.com.johnsquispe.thechess.domain.usuario.UsuarioCadastroService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("!prod")
public class StatupRunner implements ApplicationRunner {

    private static final String NICKNAME = "johnsquispe";

    private final UsuarioBuscaService usuarioBuscaService;
    private final UsuarioCadastroService usuarioCadastroService;

    public StatupRunner(UsuarioBuscaService usuarioBuscaService, UsuarioCadastroService usuarioCadastroService) {
        this.usuarioBuscaService = usuarioBuscaService;
        this.usuarioCadastroService = usuarioCadastroService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Optional<Usuario> usuarioOptional = usuarioBuscaService.buscarPorNickname(NICKNAME);

        if (usuarioOptional.isPresent()) {
            return;
        }

        ApplicationLogger.info("--->>>> INICIO: CADASTRANDO PRIMEIRO USUÁRIO DO THE CHESS", this.getClass());

        Usuario usuario = new Usuario(NICKNAME, "johns.quispe@gmail.com", "John321", Usuario.TipoConta.COMUM);

        usuarioCadastroService.salvar(usuario);

        ApplicationLogger.info("--->>>> FIM: CADASTRO PRIMEIRO USUÁRIO DO THE CHESS", this.getClass());

    }
}
