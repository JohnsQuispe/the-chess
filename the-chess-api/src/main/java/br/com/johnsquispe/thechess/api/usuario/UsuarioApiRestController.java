package br.com.johnsquispe.thechess.api.usuario;

import br.com.johnsquispe.thechess.domain.RecursoNaoEncontradoException;
import br.com.johnsquispe.thechess.domain.usuario.Usuario;
import br.com.johnsquispe.thechess.domain.usuario.UsuarioBuscaService;
import br.com.johnsquispe.thechess.domain.usuario.UsuarioSenhaService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
* Usuário deve existir, mas não deixar isso explícito na tela
 * Trim no email please
 * Enviar email pela aws api (usar a AWS SDK e a aws em si para o envio de email)
 * Comprar um domínio pls
 * Depois de solicitar nova senha, criar um token expirável de 5 minutos
 * Se o token estiver expirado, não será possível utilizá-lo (nem ferrando)
 * Se o token está válido, o usuário deve criar uma senha nova (e repeti-la)
 * Após isso o token deve ser invalidado (seta um null lá)
* */

@RestController
@AllArgsConstructor
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioApiRestController {

    private final UsuarioBuscaService usuarioBuscaService;
    private final UsuarioSenhaService usuarioSenhaService;

    @PatchMapping(UsuarioUrls.USUARIO_CRIAR_TOKEN_RESET_SENHA)
    public ResponseEntity<?> criarNovoTokenResetSenha (@Param(UsuarioUrls.Params.USUARIO_UUID) UUID usuarioUuid) {

        try {

            final Usuario usuario = usuarioBuscaService.buscarPorUuid(usuarioUuid);
            usuarioSenhaService.criarNovoTokenResetSenha(usuario);

            return ResponseEntity.ok().build();

        } catch (RecursoNaoEncontradoException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}
