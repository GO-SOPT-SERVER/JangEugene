package sopt.org.SecondSeminar.domain.post;

import lombok.Getter;

@Getter // 객체에 맞는 클래스 정의
public class Post { // 하나의 엔티티 Post 라는 테이블에서 세가지 속성을 가지겠다.

    private long id;
    private String title;
    private String content;

    public Post(String title, String content) { // 게시물을 불러올 메서드
        this.title = title;
        this.content = content;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {this.title = title;}

    public void setContent(String content) {this.content = content;}


    @Override
    public String toString(){
        return "id: " + this.id + "\n" +
                "title: " + this.title + "\n" +
                "content: " + this.content + "\n";

        }
    public String idToString(){                 // 제목과 글 내용만 불러오고 싶어서 따로 만들어 줬습니다.
        return "제목: " + this.title + "\n" +
                "글내용: " + this.content + "\n";
    }

}
