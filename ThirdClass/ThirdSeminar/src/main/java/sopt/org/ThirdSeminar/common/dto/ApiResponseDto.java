package sopt.org.ThirdSeminar.common.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import sopt.org.ThirdSeminar.exception.ErrorStatus;
import sopt.org.ThirdSeminar.exception.SuccessStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponseDto<T> {

    private final int code; // 키값 anootation 뜻 찾아보기  => 키와 Value로 나뉘어져 있음
    private final String message; // 전달 메시지 message
    private T data; // 데이터 형태 (객체, 배열 String 뭐가 올지 몰라서 제네릭 타입 => 클라이언트랑 협의 => 그 뒤 변경)

    public static ApiResponseDto success(SuccessStatus successStatus) {
        return new ApiResponseDto<>(successStatus.getHttpStatus()/* 코드 */.value(), successStatus.getMessage());
    }
    // api통신을 하면 무조건 보내야 하는거 아님. 생성을 하고 뿌려줄 필요가 있음. 게시글을 작성하고 반드시 보여줄 필요 없음, 삭제

    public static <T> ApiResponseDto<T> success(SuccessStatus successStatus, T data) {
        return new ApiResponseDto<T>(successStatus.getHttpStatus().value(), successStatus.getMessage()/* 메시지 */, data /* 데이타*/);
    }

    public static ApiResponseDto error(ErrorStatus errorStatus) {
        return new ApiResponseDto<>(errorStatus.getHttpStatus().value(), errorStatus.getMessage());
    }
}