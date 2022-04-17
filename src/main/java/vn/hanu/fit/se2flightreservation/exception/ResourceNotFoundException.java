package vn.hanu.fit.se2flightreservation.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    private String resourceName;
    private String fieldName;
    private Object filedValue;

    public ResourceNotFoundException(String message) {
        super(message);
    }


    public ResourceNotFoundException(String resourceName, String fieldName, Object filedValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, filedValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.filedValue = filedValue;
    }
}

