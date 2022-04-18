package vn.hanu.fit.se2flightreservation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <code>422</code>
 * <p>the server understands the content type of the request entity </p>
 * <p>but was unable to process the contained instructions.</p>
 */
@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class EntityExistedByIdException extends RuntimeException{
    private static final Long serialVersionUID = 1L;

    private String resourceName;
    private String fieldName;
    private Object filedValue;

    public EntityExistedByIdException(String resourceName, String fieldName, Object filedValue) {
        super(String.format("%s is existed with %s : '%s'", resourceName, fieldName, filedValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.filedValue = filedValue;
    }

}
