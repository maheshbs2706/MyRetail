package com.mrp.exceptionhandler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mrp.constants.GlobalConstants;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleConflict(HttpServletRequest request, Exception e) {

		log.error(" Error Details : {}", e);
		LogReference log = new LogReference();
		log.setLogRef(request.getAttribute(GlobalConstants.TRACKID).toString());
		log.setMsg(GlobalConstants.FAILEDREQUEST);

		return new ResponseEntity<Object>(log, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}