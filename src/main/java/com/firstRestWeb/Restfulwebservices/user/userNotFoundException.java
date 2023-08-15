package com.firstRestWeb.Restfulwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class userNotFoundException extends Throwable {
    public userNotFoundException(String message) {
        super(message);
    }
}
