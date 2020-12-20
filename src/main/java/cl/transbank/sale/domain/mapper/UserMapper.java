package cl.transbank.sale.domain.mapper;


import cl.transbank.sale.data.model.User;
import cl.transbank.sale.domain.model.UserDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserMapper implements Converter<Optional<User>, Optional<UserDTO>> {

    @Override
    public Optional<UserDTO> convert(Optional<User> source) {
        return source.map(x -> UserDTO.builder()
                .username(x.getUsername())
                .password(x.getPassword())
                .build());
    }
}