package ar.com.fluxit.candidatos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Pablo on 3/11/2019.
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CreateException extends Exception {
    public CreateException() {
        super("No se pudo crear el usuario");
    }
}
