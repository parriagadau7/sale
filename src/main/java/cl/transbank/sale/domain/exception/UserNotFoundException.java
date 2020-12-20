package cl.transbank.sale.domain.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String username) {
        super("Could not find User " + username);
    }
}
