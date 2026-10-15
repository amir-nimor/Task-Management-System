package ir.maktabsharif.service.user;

import ir.maktabsharif.dto.user.UserRequestDto;
import ir.maktabsharif.dto.user.UserResponseDto;

import java.util.List;

public interface UserService  {


    UserResponseDto save(UserRequestDto userRequestDto);
    UserResponseDto update(UserRequestDto userRequestDto);
    UserResponseDto delete(UserRequestDto userRequestDto);
    UserResponseDto read(UserRequestDto userRequestDto);
    List<UserResponseDto> findAll();

}
