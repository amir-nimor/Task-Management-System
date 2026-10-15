package ir.maktabsharif.command;

import ir.maktabsharif.dao.UserDao;
import ir.maktabsharif.dto.user.UserRequestDto;
import ir.maktabsharif.dto.user.UserResponseDto;

public class UserCommand implements Commandable<UserDao,UserRequestDto,UserResponseDto> {





    @Override
    public UserDao DtoRequestToDao(UserRequestDto userRequestDto) {
        return UserDao.builder()
                .username(userRequestDto.getUsername())
                .password(userRequestDto.getPassword())
                .build();
    }

    @Override
    public UserResponseDto DaoToDtoResponse(UserDao userDao) {
        return UserResponseDto.builder()
                .id(userDao.getId())
                .username(userDao.getUsername())
                .build();
    }
}
