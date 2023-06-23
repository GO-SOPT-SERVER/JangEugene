package sopt.org.sixthSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.sixthSeminar.controller.dto.request.BoardRequestDto;
import sopt.org.sixthSeminar.controller.dto.response.BoardResponseDto;
import sopt.org.sixthSeminar.domain.Board;
import sopt.org.sixthSeminar.domain.User;
import sopt.org.sixthSeminar.exception.Error;
import sopt.org.sixthSeminar.exception.model.NotFoundException;
import sopt.org.sixthSeminar.infrastructure.BoardRepository;
import sopt.org.sixthSeminar.infrastructure.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    @Transactional
    public void upload(Long userId, BoardRequestDto request){
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        Board newboard = Board.builder()
                .user(user)
                .title(request.getTitle())
                .content(request.getContent())
                .isPublic(request.getIsPublic())
                .build();

        boardRepository.save(newboard);
    }

    @Transactional
    public List<BoardResponseDto> search(String searchText){

        List<BoardResponseDto> searchedBoard =
                boardRepository.findAllByTitleContaining(searchText)
                .stream()
                .map(Board -> BoardResponseDto.builder()
                        .id(Board.getId())
                        .nickname(Board.getUser().getNickname())
                        .title(Board.getTitle())
                        .content(Board.getContent())
                        .isPublic(Board.getIsPublic())
                        .build())
                .collect(Collectors.toList());

        return searchedBoard;
    }
}