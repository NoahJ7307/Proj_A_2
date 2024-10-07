package com.projA.projA.controller;

import com.projA.projA.dto.PageRequestDTO;
import com.projA.projA.dto.PageResponseDTO;
import com.projA.projA.dto.UserDTO;
import com.projA.projA.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserController {
    private final UserService service;

    @GetMapping("/list")
    public PageResponseDTO<UserDTO> getList(PageRequestDTO pageRequestDTO){
        System.out.println("List.... : "+pageRequestDTO);
        return service.getList(pageRequestDTO);
    }

    @GetMapping("/{uno}")
    public UserDTO read(@PathVariable(name = "uno") Long uno){
        System.out.println("uno....(^人^) : "+uno);
        return service.getUno(uno);
    }
}
