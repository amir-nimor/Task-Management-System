package ir.maktabsharif.service.user;

import ir.maktabsharif.command.UserCommand;
import ir.maktabsharif.dao.UserDao;
import ir.maktabsharif.dto.user.UserRequestDto;
import ir.maktabsharif.dto.user.UserResponseDto;
import ir.maktabsharif.repository.user.UserRepositoryImpl;
import ir.maktabsharif.service.user.UserService;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;
public class UserServiceImpl implements UserService {

    private UserRepositoryImpl userRepository;
    private UserCommand command;

    public UserServiceImpl(UserRepositoryImpl userRepository){
        this.userRepository = userRepository;
        this.command = new UserCommand();
    }

    @Override
    public UserResponseDto save(UserRequestDto userRequestDto) {
      try {
          String hashPassword = BCrypt.hashpw(userRequestDto.getPassword(),BCrypt.gensalt());
          userRequestDto.setPassword(hashPassword);
          return command.DaoToDtoResponse(userRepository.create(command.DtoRequestToDao(userRequestDto)));
      } catch (RuntimeException e) {
          throw new RuntimeException(e);
      }
    }

    @Override
    public UserResponseDto update(UserRequestDto userRequestDto) {
        try {
            return command.DaoToDtoResponse(userRepository.update(command.DtoRequestToDao(userRequestDto)));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserResponseDto delete(UserRequestDto userRequestDto) {
        try {
            UserDao userDao = command.DtoRequestToDao(userRequestDto);
            UserResponseDto userResponseDto = UserResponseDto.builder()
                    .id(userRepository.delete(userDao.getId()))
                    .build();
            return userResponseDto;

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserResponseDto read(UserRequestDto userRequestDto) {
        try {
            UserDao userDao = command.DtoRequestToDao(userRequestDto);
            UserResponseDto userResponseDto = command.DaoToDtoResponse(userRepository.read(userDao.getId()));
            return userResponseDto;

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserResponseDto> findAll() {
        try {
            List<UserDao> userDaos = userRepository.findAll();
            return userDaos.stream()
                    .map(u -> command.DaoToDtoResponse(u))
                    .toList();
        }catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
