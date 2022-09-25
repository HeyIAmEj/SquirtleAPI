package br.com.squirtle.repository;


import br.com.squirtle.model.Usuario;
import br.com.squirtle.model.UsuarioDispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface LinkRepository extends JpaRepository<UsuarioDispositivo, Long> {


}
