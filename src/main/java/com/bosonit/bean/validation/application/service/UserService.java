package com.bosonit.bean.validation.application.service;

import com.bosonit.bean.validation.application.Planet;
import com.bosonit.bean.validation.domain.User;
import com.bosonit.bean.validation.infrastructure.dto.UserDTO;
import com.bosonit.bean.validation.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public UserDTO saveUser(UserDTO userDTO){
        userRepository.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public int suma(int num1, int num2) {
        return num1 + num2;
    }

    public int division(int num1, int num2) {
        return num1 / num2;
    }

    public boolean checkPlanet(Planet planet) {
        return switch (planet) {
            case MARS, VENUS, JUPITER -> true;
            default -> false;
        };
    }
}
