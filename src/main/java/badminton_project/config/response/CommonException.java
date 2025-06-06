package badminton_project.config.response;

import lombok.Getter;

@Getter
public class CommonException extends RuntimeException {

    private ErrorCode errorCode;

    public CommonException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
