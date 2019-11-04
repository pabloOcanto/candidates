package ar.com.fluxit.candidatos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Pablo on 4/11/2019.
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class UpdateException extends Exception {

    public UpdateException(){
        super("No se pudo actualizar el usuario");
    }
}
