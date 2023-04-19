package com.github.aza0602.stream.streamapiandoptional.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmployeeStoragesFullException extends RuntimeException{
}
