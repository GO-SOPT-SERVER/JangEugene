package sopt.org.SecondSeminar.controller.post; // controller 클라이언트에게 받고 보내고만

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.org.SecondSeminar.controller.post.dto.request.SaveRequestDto;
import sopt.org.SecondSeminar.service.PostService;
import static sopt.org.SecondSeminar.SecondSeminarApplication.postList;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/post")
    public String register(@RequestBody final SaveRequestDto request) {

        Long userId = postService.save(request); // 컨트롤러가 service한테 요청. 일을 대신 시킴
        System.out.println(postList);            // servics는 글에 대한 서비스 컨트롤러는 어디로 향하는지 중간다리

        return userId + "번 글 등록이 완료됐습니다.";
    }

    @GetMapping("/post/{userId}") // 아이디로 게시물을 찾는 메서드
    public String getOne(@PathVariable final Long userId) {
        System.out.println(userId + "의 게시물 조회" + postList.get(userId.intValue()-1)); // 최고


        return postService.getPostInfo(userId); // 보내주기만 한다.
    }

    @GetMapping("/post/search") // 제목으로 글을 찾는 메서드
    public String search(@RequestParam final String title) {
        System.out.println("글 제목으로 검색: " + title);

        return postService.getByTitle(title);
    }
}
