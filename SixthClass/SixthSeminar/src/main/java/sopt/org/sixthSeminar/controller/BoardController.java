package sopt.org.sixthSeminar.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sopt.org.sixthSeminar.common.dto.ApiResponse;
import sopt.org.sixthSeminar.config.resolver.UserId;
import sopt.org.sixthSeminar.controller.dto.request.BoardImageListRequestDto;
import sopt.org.sixthSeminar.controller.dto.request.BoardRequestDto;
import sopt.org.sixthSeminar.controller.dto.response.BoardResponseDto;
import sopt.org.sixthSeminar.exception.Success;
import sopt.org.sixthSeminar.service.BoardService;

import javax.validation.Valid;
import java.util.List;

@RestController

@RequiredArgsConstructor
@RequestMapping("/board")
@SecurityRequirement(name = "JWT Auth")
public class BoardController {

    private final BoardService boardService;


    @PostMapping(value = "/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse upload(@UserId Long userId, @ModelAttribute @Valid final BoardRequestDto request){
        boardService.upload(userId, request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }

    @GetMapping(value = "/search")
    @ResponseStatus(HttpStatus.OK)
    public List<BoardResponseDto> search(@UserId Long Id, @RequestParam("searchText") String searchText){
        List<BoardResponseDto> searchedBoard = boardService.search(searchText);

        return searchedBoard;
    }




}