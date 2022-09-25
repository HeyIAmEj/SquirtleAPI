package br.com.squirtle.exception;

public class DispositivoNaoEncontradoException extends Exception {
    public DispositivoNaoEncontradoException(Long id) {
        super(String.format("Dispositivo %d não encontrado! ", id));
    }
}