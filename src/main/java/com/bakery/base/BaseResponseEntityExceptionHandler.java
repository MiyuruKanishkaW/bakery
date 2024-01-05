package com.bakery.base;

import com.bakery.exceptions.NoRecordFoundException;
import com.bakery.exceptions.UserNotFound;
import com.bakery.exceptions.ValidateRecordException;
import com.bakery.resource.CommonResource;
import com.bakery.resource.MessageResponseResource;
import com.bakery.resource.ValidateResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.lang.reflect.Field;


/**
 * 
 * This will return the relevant object based on the caught exception
 * 
 * @author menukaj
 * 
 */
@RestControllerAdvice
public class BaseResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private Environment environment;

	@Override 
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) { 
		MessageResponseResource messageResponseResource = new MessageResponseResource();
		messageResponseResource.setMessage(environment.getProperty("common.invalid-url-pattern"));
		messageResponseResource.setDetails(ex.getMessage());
		return new ResponseEntity<>(messageResponseResource, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({NoRecordFoundException.class})
	public ResponseEntity<Object> noRecordFoundException(NoRecordFoundException ex, WebRequest request) {
		MessageResponseResource messageResponseResource = new MessageResponseResource();
		messageResponseResource.setMessage(ex.getMessage());
		return new ResponseEntity<>(messageResponseResource, HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler({UserNotFound.class})
    public ResponseEntity<Object> userNotFoundException(UserNotFound ex, WebRequest request) {
		MessageResponseResource messageResponseResource = new MessageResponseResource();
        messageResponseResource.setMessage(ex.getMessage());
        return new ResponseEntity<>(messageResponseResource, HttpStatus.UNPROCESSABLE_ENTITY);
    }
	
	@ExceptionHandler({ValidateRecordException.class})
	public ResponseEntity<Object> validateRecordException(ValidateRecordException ex, WebRequest request) {
		try {
		ValidateResource typeValidation = new ValidateResource();
		Class validationDetailClass = typeValidation.getClass();
		Field sField = validationDetailClass.getDeclaredField(ex.getField());
		sField.setAccessible(true);
		sField.set(typeValidation, ex.getMessage());
		return new ResponseEntity<>(typeValidation, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		catch (Exception e) {
			MessageResponseResource messageResponseResource = new MessageResponseResource();
			messageResponseResource.setMessage(environment.getProperty("common.internal-server-error"));
			messageResponseResource.setDetails(e.getMessage());
			return new ResponseEntity<>(messageResponseResource, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override 
	 protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) { 
		
		try {
			 Field sField=null;
			 String fieldName=null;
			 Integer index=null;
			 Integer atPoint=null;
			 Integer index1=null;
			 Integer atPoint1=null;
			String className=ex.getBindingResult().getObjectName();
			switch(className){ 
        		
        	case "commonResource":
				CommonResource commonResource = new CommonResource();
				for (FieldError error : ex.getBindingResult().getFieldErrors()) {
					sField =  commonResource.getClass().getDeclaredField(error.getField());
		            sField.setAccessible(true);
		            sField.set(commonResource.getClass().cast(commonResource), error.getDefaultMessage());
				}
				return new ResponseEntity<>(commonResource, HttpStatus.UNPROCESSABLE_ENTITY);
	        default:   
	        	return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
	        }
		} catch (Exception e) {
			MessageResponseResource messageResponseResource = new MessageResponseResource();
			messageResponseResource.setMessage(environment.getProperty("common.internal-server-error"));
			messageResponseResource.setDetails(e.getMessage());
			return new ResponseEntity<>(messageResponseResource, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	 }				

	@ExceptionHandler({Exception.class})
	public ResponseEntity<Object> exception(Exception ex, WebRequest request) {
		MessageResponseResource messageResponseResource = new MessageResponseResource();
		messageResponseResource.setMessage(ex.getMessage());
		return new ResponseEntity<>(messageResponseResource, HttpStatus.UNPROCESSABLE_ENTITY);

	}
	
	

}
