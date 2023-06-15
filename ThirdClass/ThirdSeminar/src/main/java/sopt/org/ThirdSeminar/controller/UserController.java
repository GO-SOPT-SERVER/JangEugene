package sopt.org.ThirdSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.ThirdSeminar.common.dto.ApiResponseDto;
import sopt.org.ThirdSeminar.controller.dto.request.UserRequestDto;
import sopt.org.ThirdSeminar.controller.dto.response.UserResponseDto;
import sopt.org.ThirdSeminar.exception.SuccessStatus;
import sopt.org.ThirdSeminar.service.UserService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ApiResponseDto<UserResponseDto>> create(@RequestBody @Valid final UserRequestDto request) {
        return new ResponseEntity<>(ApiResponseDto.success(SuccessStatus.SIGNUP_SUCCESS, userService.create(request)), HttpStatus.CREATED);
    } // Dto를 뿌려주는데 @controller 뷰를 뿌려줌 => html 파일 , @'Rest'Controller는 이 객체를 그대로 Json으로 키 값으로 만들어줌
}