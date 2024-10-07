package com.projA.projA.service;

import com.projA.projA.domain.UserEntity;
import com.projA.projA.dto.PageRequestDTO;
import com.projA.projA.dto.PageResponseDTO;
import com.projA.projA.dto.UserDTO;
import com.projA.projA.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final ModelMapper mapper;
    private final UserRepository userRepository;

    private UserEntity dtoToEntity(UserDTO userDTO){
        UserEntity userEntity = UserEntity.builder()
                .dong(userDTO.getDong())
                .ho(userDTO.getHo())
                .name(userDTO.getName())
                .phone(userDTO.getPhone())
                .pw(userDTO.getPw())
                .build();
        return userEntity;
    }

    private UserDTO entityToDTO(UserEntity userEntity){
        UserDTO userDTO = UserDTO.builder()
                .dong(userEntity.getDong())
                .ho(userEntity.getHo())
                .name(userEntity.getName())
                .phone(userEntity.getPhone())
                .pw(userEntity.getPw())
                .build();
        return userDTO;
    }

    @Override
    public Long register(UserDTO userDTO) {
        System.out.println("Service 등록.....");
        UserEntity user = mapper.map(userDTO, UserEntity.class);
        UserEntity savedUser = userRepository.save(user);
        return savedUser.getUno();
    }

    @Override
    public UserDTO getUno(Long uno) {
        System.out.println("Service 조회....."+uno);
        Optional<UserEntity> result = userRepository.findById(uno);
        UserEntity user = result.orElseThrow();
        UserDTO dto = mapper.map(user, UserDTO.class);
        return dto;
    }

    @Override
    public PageResponseDTO<UserDTO> getList(PageRequestDTO pageRequestDTO) {
        System.out.println("Service 전체 조회.....");
        Pageable pageable = PageRequest.of(
                pageRequestDTO.getPage() -1,
                pageRequestDTO.getSize(),
                Sort.by("uno").descending());

        Page<UserEntity> result = userRepository.findAll(pageable);

        List<UserDTO> dtoList = result.getContent().stream()
                .map(user -> mapper.map(user, UserDTO.class))
                .toList();

        long totalCount = result.getTotalElements();

        PageResponseDTO<UserDTO> responseDTO = PageResponseDTO.<UserDTO>withAll()
                .dtoList(dtoList)
                .pageRequestDTO(pageRequestDTO)
                .totalCount(totalCount)
                .build();

        return responseDTO;
    }
}
