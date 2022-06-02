package com.bosonit.bean.validation.application.service;

import com.bosonit.bean.validation.application.Planet;
import com.bosonit.bean.validation.domain.User;
import com.bosonit.bean.validation.infrastructure.dto.UserDTO;
import com.bosonit.bean.validation.infrastructure.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private UserDTO userDTOMock;

    @Mock
    private User userMock;

    @Test
    void saveUser_validUser_userSavedSuccessfully() {
        // 1. Config test
        when(modelMapper.map(any(UserDTO.class), any())).thenReturn(userMock);
        UserService userService = new UserService(userRepository, modelMapper);

        // 2. Ejecutar método deseado
        UserDTO userDTO = userService.saveUser(userDTOMock);

        // 3. Comprobar resultados
        // Verificar llamadas a dependencias
        verify(userRepository).save(userMock);
        verify(modelMapper).map(userDTOMock, User.class);
        // Assert de resultado del método testeado
        assertEquals(userDTOMock, userDTO);
    }

    @Test
    void suma_anyNumbers_numerosSumadosCorrectamente() {
        // 1. Config test
        UserService userService = new UserService(userRepository, modelMapper);

        // 2. Ejecutar método deseado
        int result = userService.suma(1, 1);

        // 3. Comprobar resultados
        // Valor esperado == valor recibido
        assertEquals(2, result);
    }

    @Test
    void division_divisorDiferenteDe0_numerosDivididosCorrectamente() {
        // 1. Config test
        UserService userService = new UserService(userRepository, modelMapper);

        // 2. Ejecutar método deseado
        double result = userService.division(8, 2);

        // 3. Comprobar resultados
        // Valor esperado == valor recibido
        assertEquals(4, result);
    }

    @Test
    void division_divisorIgualA0_lanzaArithmeticException() {
        // 1. Config test
        UserService userService = new UserService(userRepository, modelMapper);

        // 2. Ejecutar método deseado
//        int result = userService.division(8, 0);

        // 3. Comprobar resultados
        // Valor esperado == valor recibido
        assertThrows(ArithmeticException.class, () -> userService.division(8, 0));
    }

    @Test
    void checkPlanet_planetaTierra_returnsFalse() {
        // 1. Config test
        UserService userService = new UserService(userRepository, modelMapper);

        // 2. Ejecutar método deseado
        boolean result = userService.checkPlanet(Planet.EARTH);

        // 3. Comprobar resultados
        // Valor esperado == valor recibido
        assertFalse(result);
    }

    @Test
    void checkPlanet_planetaDiferenteDeTierra_returnsTrue() {
        // 1. Config test
        UserService userService = new UserService(userRepository, modelMapper);

        // 2. Ejecutar método deseado
//        boolean result = userService.checkPlanet(Planet.VENUS);

        // 3. Comprobar resultados
        // Valor esperado == valor recibido
        assertTrue(userService.checkPlanet(Planet.VENUS));
        assertTrue(userService.checkPlanet(Planet.JUPITER));
        assertTrue(userService.checkPlanet(Planet.MARS));
    }

}