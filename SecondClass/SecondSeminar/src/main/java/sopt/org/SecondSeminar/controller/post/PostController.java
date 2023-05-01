package sopt.org.SecondSeminar.controller.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.org.SecondSeminar.controller.post.dto.request.SaveRequestDto;
import sopt.org.SecondSeminar.controller.post.dto.request.UpdateRequestDto;
import sopt.org.SecondSeminar.service.PostService;
import static sopt.org.SecondSeminar.SecondSeminarApplication.postList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1") // api 버전 처리

public class PostController {
    private final PostService postService;

    @PostMapping("/posts")
    public String register(@RequestBody final SaveRequestDto request) {

        Long userId = postService.save(request); // 컨트롤러가 service한테 요청. 일을 대신 시킴
        System.out.println(postList);           // // servics는 글에 대한 서비스 컨트롤러는 어디로 향하는지 중간다리

            return userId + "번 글 등록이 완료됐습니다.";
        }

        @GetMapping("/posts/{userId}") // 아이디로 게시물을 찾는 메서드
        public String getOne(@PathVariable final Long userId) {
            System.out.println(userId + "의 게시물 조회" + postList.get(userId.intValue()-1)); // 최고


            return postService.getPostInfo(userId); // 보내주기만 한다.
        }

        @GetMapping("/posts") // 제목으로 글을 찾는 메서드

        public String search(@RequestParam final String title) {
            System.out.println("글 제목으로 검색: " + title);

            return postService.getByTitle(title);
        }

        @PutMapping("/posts/{userId}") // 글을 수정하는 메서드
        public String update(@PathVariable final Long userId, @RequestBody UpdateRequestDto update) {
            System.out.println(userId + " 님의 글을 수정했습니다.");

            return postService.updatePost(userId, update);
        }

        @DeleteMapping("/posts/{userId}") // API에 행위가 들어가면 안된다는 피드백으로 변경
        public String delete(@PathVariable final Long userId){
            System.out.println(userId + " 님의 글을 삭제했습니다.");

            return postService.deletePost(userId);
        }

    }