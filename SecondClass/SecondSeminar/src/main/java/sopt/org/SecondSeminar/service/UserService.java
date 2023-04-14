package sopt.org.SecondSeminar.service;

import org.springframework.stereotype.Service;
import sopt.org.SecondSeminar.controller.user.dto.request.RegisterRequestDto;
import sopt.org.SecondSeminar.domain.user.User;

import static sopt.org.SecondSeminar.SecondSeminarApplication.userList;

@Service
public class UserService {
    public Long register(RegisterRequestDto request) {
      User newUser = new User(
              request.getGender(),
              request.getName(),
              request.getContact(),
              request.getAge()
      );

      //데이터 베이스에 저장
        userList.add(newUser);
        newUser.setId((long) userList.size());

        //저장한 유저 아이디 값 반환
        return newUser.getId();
    };
}
