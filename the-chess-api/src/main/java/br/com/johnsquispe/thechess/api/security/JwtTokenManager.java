package br.com.johnsquispe.thechess.api.security;

import br.com.johnsquispe.thechess.domain.usuario.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenManager {

    private final String secret;
    private final long expirationTimeInMillis;

    public JwtTokenManager(@Value("${jwt.secret}") String secret,
                            @Value("${jwt.expiration}") long expirationTimeInMillis) {
        this.secret = secret;
        this.expirationTimeInMillis = expirationTimeInMillis;
    }

    public String gerarToken (UsuarioAuth usuarioAuth) {

        final Date now = new Date();
        final Date expiration = new Date(now.getTime() + this.expirationTimeInMillis);

        return Jwts.builder()
                    .setIssuer("The Chess Application")
                    .setSubject(String.valueOf(usuarioAuth.getId()))
                    .claim(ClaimsConstantes.NICKNAME, usuarioAuth.getNickname())
                    .claim(ClaimsConstantes.TIPO_CONTA, usuarioAuth.getTipoConta())
                    .setExpiration(expiration)
                    .signWith(SignatureAlgorithm.HS256, this.secret)
                .compact();

    }

    public UsuarioAuth recuperarUsuarioPeloToken (String token) {

        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();

        return new UsuarioAuth(Long.valueOf(claims.getSubject()),
                                                    claims.get(ClaimsConstantes.NICKNAME).toString(),
                                                    StringUtils.EMPTY,
                                                    Usuario.TipoConta.valueOf(claims.get(ClaimsConstantes.TIPO_CONTA).toString()));

    }

    public boolean isValid (String token) {

        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }

    }

}
