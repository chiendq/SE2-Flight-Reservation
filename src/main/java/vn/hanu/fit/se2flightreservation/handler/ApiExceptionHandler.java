//package vn.hanu.fit.se2flightreservation.handler;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//import vn.hanu.fit.se2flightreservation.exceptions.EntityExistedByIdException;
//import vn.hanu.fit.se2flightreservation.exceptions.ResourceNotFoundException;
//
//@RestControllerAdvice
//public class ApiExceptionHandler {
//    /**
//     * All Exception that not be declared will be executed here
//     */
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//    public ErrorMessage handleAllException(Exception ex, WebRequest request) {
//        // exception handle here
//        return new ErrorMessage(500, ex.getLocalizedMessage());
//    }
//
//    /**
//     * ResourceNotFoundException will be executed here
//     */
//    @ExceptionHandler(ResourceNotFoundException.class)
//    @ResponseStatus(value = HttpStatus.NOT_FOUND)
//    public ErrorMessage ResourceNotFoundException(Exception ex, WebRequest request) {
//        return new ErrorMessage(404, "Empty");
//    }
//
//    /**
//     * ResourceNotFoundException will be executed here
//     */
//    @ExceptionHandler(EntityExistedByIdException.class)
//    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
//    public ErrorMessage EntityExistedByIdException(Exception ex, WebRequest request) {
//        return new ErrorMessage(422, "Existed");
//    }
//}
