package com.projA.projA.service;


import com.projA.projA.dto.PageRequestDTO;
import com.projA.projA.dto.PageResponseDTO;
import com.projA.projA.dto.UserDTO;

public interface UserService {
    Long register(UserDTO userDTO);
    UserDTO getUno(Long uno);
    PageResponseDTO<UserDTO> getList(PageRequestDTO pageRequestDTO);
}
