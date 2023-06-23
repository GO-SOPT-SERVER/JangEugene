package sopt.org.sixthSeminar.exception.model;

import lombok.Getter;
import sopt.org.sixthSeminar.exception.Error;
// 파일이름은 컨벤션 찾아보기

@Getter
public class SoptException extends RuntimeException {

    private final Error error;

    public SoptException(Error error, String message) {
        super(message);
        this.error = error;
    }

    public int getHttpStatus() {
        return error.getHttpStatusCode();
    }
}