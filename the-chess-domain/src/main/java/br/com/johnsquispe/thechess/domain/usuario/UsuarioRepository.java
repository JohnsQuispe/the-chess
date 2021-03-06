package br.com.johnsquispe.thechess.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNickname (String nickName);
    Optional<Usuario> findByUuid (UUID uuid);


}
