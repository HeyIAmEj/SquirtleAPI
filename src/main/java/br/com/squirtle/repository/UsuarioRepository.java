package br.com.squirtle.repository;


import br.com.squirtle.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsUsuarioByEmail(String email);

    Usuario findUsuarioByEmailAndSenha(String email, String senha);
    Usuario findByEmail(String email);
}
