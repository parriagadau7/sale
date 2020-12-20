package cl.transbank.sale.domain.usescase;

import cl.transbank.sale.api.config.JwtProvider;
import cl.transbank.sale.data.repository.UserRepository;
import cl.transbank.sale.domain.exception.UserNotFoundException;
import cl.transbank.sale.domain.mapper.UserMapper;
import cl.transbank.sale.domain.model.JwtResponse;
import cl.transbank.sale.domain.model.UserDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class LoginUseCase {

    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public JwtResponse login(UserDTO user) {
        Optional<UserDTO> userOptional = userMapper.convert(
                userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()));

        if (userOptional.isPresent()) {
            return JwtResponse.builder()
                    .token(jwtProvider.generateJwtToken(userOptional.get().getUsername()))
                    .build();
        } else {
            log.error("user not found {}", user.getUsername());
            throw new UserNotFoundException(user.getUsername());
        }
    }
}
