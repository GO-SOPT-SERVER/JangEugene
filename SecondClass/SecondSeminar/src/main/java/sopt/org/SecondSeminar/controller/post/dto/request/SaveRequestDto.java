package sopt.org.SecondSeminar.controller.post.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SaveRequestDto {
    private String title;
    private String content;
}
