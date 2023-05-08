package pe.bci.com.clients.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteException extends RuntimeException {

    private String message;

    public ClienteException(String message) {
        this.message = message;
    }


}
