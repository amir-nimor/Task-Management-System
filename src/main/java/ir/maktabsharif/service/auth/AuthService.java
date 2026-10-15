package ir.maktabsharif.service.auth;

import ir.maktabsharif.command.UserCommand;
import ir.maktabsharif.dao.UserDao;
import ir.maktabsharif.dto.user.UserResponseDto;
import ir.maktabsharif.exception.InvalidCredentialsException;
import ir.maktabsharif.repository.auth.AuthRepository;
import ir.maktabsharif.repository.user.UserRepositoryImpl;
import ir.maktabsharif.util.PasswordUtil;

public class AuthService {
    private AuthRepository authRepository;

    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public UserResponseDto loginWithUsernameAndPassword(String username, String password) {
        UserDao user = authRepository.getUser(username);
        if (user == null || !PasswordUtil.checkPassword(password, user.getPassword())) {
            throw new InvalidCredentialsException("Invalid username or password");
        }

        return new UserCommand().DaoToDtoResponse(user);
    }
}
