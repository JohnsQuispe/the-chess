package br.com.johnsquispe.thechess.api.security;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final String BEARER_PREFIX = "Bearer";

    private final JwtTokenManager jwtTokenManager;

    public JwtAuthenticationFilter(JwtTokenManager jwtTokenManager) {
        this.jwtTokenManager = jwtTokenManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String token = recuperarTokenDaRequisicao(httpServletRequest);

        if (jwtTokenManager.isValid(token)) {

            UserDetails userDetails = jwtTokenManager.recuperarUsuarioPeloToken(token);

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }

    private String recuperarTokenDaRequisicao (HttpServletRequest httpServletRequest) {

        String bearerToken = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);

        if (StringUtils.startsWith(bearerToken, BEARER_PREFIX + " ")) {
            return bearerToken.substring(BEARER_PREFIX.length() + 1, bearerToken.length());
        }

        return null;

    }


}
