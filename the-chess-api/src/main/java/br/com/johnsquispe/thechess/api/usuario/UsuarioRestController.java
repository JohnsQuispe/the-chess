package br.com.johnsquispe.thechess.api.usuario;

import br.com.johnsquispe.thechess.api.to.ListaFieldErrorTO;
import br.com.johnsquispe.thechess.domain.logger.ApplicationLogger;
import br.com.johnsquispe.thechess.domain.usuario.Usuario;
import br.com.johnsquispe.thechess.domain.usuario.UsuarioBuscaService;
import br.com.johnsquispe.thechess.domain.usuario.UsuarioCadastroService;
import br.com.johnsquispe.thechess.infraestructure.usuario.UsuarioQueryBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioRestController {

    private final UsuarioBuscaService usuarioBuscaService;
    private final UsuarioCadastroService usuarioCadastroService;

    public UsuarioRestController(UsuarioBuscaService usuarioBuscaService, UsuarioCadastroService usuarioCadastroService) {
        this.usuarioBuscaService = usuarioBuscaService;
        this.usuarioCadastroService = usuarioCadastroService;
    }

    @GetMapping (Urls.USUARIO)
    public ResponseEntity<?> listarTodosUsuarios () {

        try {

            List<Usuario> usuarioList = usuarioBuscaService.buscarTodosPorFiltro(new UsuarioQueryBuilder());

            return ResponseEntity.ok(ListaUsuarioOutputWrapper.of(usuarioList));

        } catch (Exception e) {
            ApplicationLogger.error("Ocorreu um erro ao buscar lista de usuários", this.getClass(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping(Urls.USUARIO)
    public ResponseEntity<?> criarUsuario (@Valid @RequestBody UsuarioInput usuario, BindingResult bindingResult) {

        try {

            if (bindingResult.hasErrors()) {
                return ResponseEntity.badRequest().body(ListaFieldErrorTO.of(bindingResult));
            }

            Usuario usuarioParaPersistir = usuario.toUsuario();

            usuarioCadastroService.salvar(usuarioParaPersistir);
            
        } catch (Exception e) {
            ApplicationLogger.error("Ocorreu um erro ao salvar o cliente", this.getClass(), e);
        }

        return ResponseEntity.ok().build();

    }

}
