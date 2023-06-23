package sopt.org.sixthSeminar.controller.dto.response;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponseDto {

    private Long userId;
    private String nickname;

    @Builder
    public static UserResponseDto of(Long userId, String nickname) {
        return new UserResponseDto(userId, nickname);
    }
}