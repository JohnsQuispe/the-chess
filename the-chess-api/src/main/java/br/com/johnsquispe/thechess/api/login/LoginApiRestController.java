package br.com.johnsquispe.thechess.api.login;

import br.com.johnsquispe.thechess.api.security.JwtTokenManager;
import br.com.johnsquispe.thechess.api.security.UsuarioAuth;
import br.com.johnsquispe.thechess.api.to.ListaFieldErrorTO;
import br.com.johnsquispe.thechess.domain.logger.ApplicationLogger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginApiRestController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenManager jwtTokenManager;

    public LoginApiRestController(AuthenticationManager authenticationManager, JwtTokenManager jwtTokenManager) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenManager = jwtTokenManager;
    }

    @PostMapping(LoginUrl.LOGIN)
    public ResponseEntity<?> logar (@Valid @RequestBody LoginInput loginInput, BindingResult bindingResult) {

        try {

            if (bindingResult.hasErrors()) {
                return ResponseEntity.badRequest().body(ListaFieldErrorTO.of(bindingResult));
            }

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginInput.getNickname(),
                                                                                                                loginInput.getSenha());
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            UsuarioAuth usuarioAuth = (UsuarioAuth) authentication.getPrincipal();
            String token = jwtTokenManager.gerarToken(usuarioAuth);

            return ResponseEntity.ok(new LoginOutput(token));

        } catch (BadCredentialsException e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        } catch (Exception e) {

            ApplicationLogger.error("Ocorreu um erro ao autenticar o usuário", this.getClass(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }


}
