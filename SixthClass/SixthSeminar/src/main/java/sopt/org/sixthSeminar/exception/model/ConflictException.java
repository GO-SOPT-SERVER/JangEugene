package sopt.org.sixthSeminar.exception.model;

import sopt.org.sixthSeminar.exception.Error;

public class ConflictException extends SoptException {  // SoptException 파일을 Extend
    public ConflictException(Error error, String message) {
        super(error, message);
    }
}