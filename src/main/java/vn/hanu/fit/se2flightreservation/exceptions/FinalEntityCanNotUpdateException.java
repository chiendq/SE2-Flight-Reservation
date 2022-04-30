package vn.hanu.fit.se2flightreservation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class FinalEntityCanNotUpdateException extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    private String resourceName;
    private String fieldName;
    private Object filedValue;

    public FinalEntityCanNotUpdateException(String resourceName, String fieldName, Object filedValue) {
        super(String.format("%s CAN NOT EDIT %s : '%s'", resourceName, fieldName, filedValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.filedValue = filedValue;
    }
}

