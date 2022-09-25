package br.com.squirtle.exception;

public class UsuarioNaoEncontradoException extends Exception {
    public UsuarioNaoEncontradoException(Long id) {
        super(String.format("Usuario %d não encontrado! ", id));
    }
}