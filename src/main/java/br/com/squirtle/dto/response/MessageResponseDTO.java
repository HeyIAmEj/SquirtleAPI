package br.com.squirtle.dto.response;

import br.com.squirtle.model.Usuario;
import lombok.*;

@Data
@Builder
public class MessageResponseDTO {

    private String message;

    public static MessageResponseDTO criarMensagemResposta(String message, Usuario usuario) {
        return MessageResponseDTO.builder().message(message + usuario.getId()).build();
    }
}