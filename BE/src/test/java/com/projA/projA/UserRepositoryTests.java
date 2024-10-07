package com.projA.projA;

import com.projA.projA.domain.UserEntity;
import com.projA.projA.dto.PageRequestDTO;
import com.projA.projA.dto.PageResponseDTO;
import com.projA.projA.dto.UserDTO;
import com.projA.projA.repository.UserRepository;
import com.projA.projA.service.UserService;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTests {
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserService service;

    @Test
    public void test1(){
        System.out.println(repository);
    }

    @Test
    public void insertUser(){
        for (int i = 0; i < 5; i++) {
            UserEntity user = UserEntity.builder()
                    .dong(101)
                    .ho(100+i)
                    .name("User"+i)
                    .pw("1111")
                    .phone("01011112222")
                    .build();
            repository.save(user);
            System.out.println("--------------"+user);
        }
    }

    @Test
    public void serviceTest(){
        UserDTO userDTO = UserDTO.builder()
                .dong(102)
                .ho(101)
                .name("UserService")
                .pw("1111")
                .phone("01011112222")
                .build();
        Long uno = service.register(userDTO);
        System.out.println("uno : "+uno);
    }

    @Test
    public void getTest(){
        Long uno = 6L;
        UserDTO dto = service.getUno(uno);
        System.out.println("dto : " + dto);
    }

    @Test
    public void pageResponseTest(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();
        PageResponseDTO<UserDTO> result = service.getList(pageRequestDTO);
        System.out.println(result);
    }
}
