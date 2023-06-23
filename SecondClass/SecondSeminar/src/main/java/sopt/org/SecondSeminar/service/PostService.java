package sopt.org.SecondSeminar.service;

import org.springframework.stereotype.Service;
import sopt.org.SecondSeminar.controller.post.dto.request.SaveRequestDto;
import sopt.org.SecondSeminar.controller.post.dto.request.UpdateRequestDto;
import sopt.org.SecondSeminar.domain.post.Post;

import java.util.ArrayList;

import static sopt.org.SecondSeminar.SecondSeminarApplication.postList;



@Service // 요청 처리 find, save 이런식으로 행위는 서비스
public class PostService {
    public Long save(SaveRequestDto requestDto){    // 저장해주는 메서드
        Post newPost = new Post(
                requestDto.getTitle(),
                requestDto.getContent()
        );

        postList.add(newPost);
        newPost.setId((long) postList.size());

        //저장한 유저 아이디 값 반환
        return newPost.getId();
        }

    public String getPostInfo(Long userId) { // 아이디로 글을 찾는 메서드
        Post post = postList.get(userId.intValue() - 1);
        Post postInfo = new Post(            // title과 content만 불러오고 싶어서 따로 만들었습니다.
                post.getTitle(),
                post.getContent()
        );

        return postInfo.idToString();
    }

    public String getByTitle(String title) {    // 찾는 제목을 포함하는 게시물을 찾는 메서드
        ArrayList<String> titlePost = new ArrayList<>();    // 일회성 Array를 만들어주고 싶었습니다.
        for(Post post: postList) {
            if (post.getTitle().contains(title)){
                titlePost.add(post.toString());
            }
        }
        return "해당 제목을 포함하는 게시물: " + titlePost;
    }
    public String updatePost(Long userId, UpdateRequestDto requestDto) {
        Post post = postList.get(userId.intValue() - 1);
        post.setContent(requestDto.getContent()); // UpdateRequestDto에서 받은것을 post에서 할당
        post.setTitle(requestDto.getTitle());

        return "게시물 수정 완료: " + post;
    }

    public String deletePost(Long userId) {
        if (userId -1 >= postList.size()) { // 유저 아이디가 postList안에 존재하지 않을때
            return "삭제할 글이 존재하지 않습니다";
        }
        postList.remove(userId.intValue() - 1); // 해당 post 삭제
        return "게시물 삭제 완료";

    }
    }
