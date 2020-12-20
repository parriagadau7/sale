package cl.transbank.sale.usescase;

import cl.transbank.sale.api.config.JwtProvider;
import cl.transbank.sale.data.repository.UserRepository;
import cl.transbank.sale.domain.exception.UserNotFoundException;
import cl.transbank.sale.domain.mapper.UserMapper;
import cl.transbank.sale.domain.model.JwtResponse;
import cl.transbank.sale.domain.usescase.LoginUseCase;
import cl.transbank.sale.usescase.config.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
class LoginUseCaseTest extends BaseTest {


    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;
    @Mock
    private JwtProvider jwtProvider;

    @InjectMocks
    private LoginUseCase loginUseCase;

    @Test
    void loginOk() {
        Mockito.when(userRepository.findByUsernameAndPassword(anyString(), anyString())).thenReturn(getUser());
        Mockito.when(userMapper.convert(any())).thenReturn(getOptionalUserDTO());
        Mockito.when(jwtProvider.generateJwtToken(anyString())).thenReturn(TOKEN);
        JwtResponse response = loginUseCase.login(getUserDTO());
        assertNotNull(response);
        assertEquals(TOKEN, response.getToken());
    }

    @Test
    void loginNOk() {
        Mockito.when(userRepository.findByUsernameAndPassword(anyString(), anyString())).thenReturn(getUser());
        Mockito.when(userMapper.convert(any())).thenReturn(Optional.empty());

        Assertions.assertThrows(UserNotFoundException.class, () -> {
            loginUseCase.login(getUserDTO());
        });
    }
}