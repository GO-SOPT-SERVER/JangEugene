package sopt.org.sixthSeminar.controller.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardResponseDto {
    private String nickname;

    private String title;

    private String content;

    private Boolean isPublic;

    private Long id;


    @Builder
    public BoardResponseDto(Long id, String nickname, String title, String content, Boolean isPublic) {
        this.id = id;
        this.nickname = nickname;
        this.title = title;
        this.content = content;
        this.isPublic = isPublic;
    }
}
