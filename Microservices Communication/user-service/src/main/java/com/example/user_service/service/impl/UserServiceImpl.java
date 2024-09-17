package com.example.user_service.service.impl;

import com.example.user_service.dto.DepartmentDto;
import com.example.user_service.dto.ResponseDto;
import com.example.user_service.dto.UserDto;
import com.example.user_service.entity.User;
import com.example.user_service.repo.UserRepository;
import com.example.user_service.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseDto getUser(Long userId) {

        ResponseDto responseDto=new ResponseDto();
        User user=userRepository.findById(userId).get();
        UserDto userDto=mapToUser(user);

        ResponseEntity<DepartmentDto>responseEntity=restTemplate
                .getForEntity("http://localhost:8080/api/departments/" +user.getDepartmentId()
                ,DepartmentDto.class);

        DepartmentDto departmentDto = responseEntity.getBody();

        System.out.println(responseEntity.getStatusCode());

        responseDto.setUser(userDto);
        responseDto.setDepartment(departmentDto);

        return responseDto;
    }

    private UserDto mapToUser(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
