package vn.hanu.fit.se2flightreservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.function.Supplier;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {
    private static final Long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }


}

