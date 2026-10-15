package ir.maktabsharif.command;

import ir.maktabsharif.dao.UserDao;
import ir.maktabsharif.dto.user.UserRequestDto;

public class TaskCommand {

    private TaskCommand(){}


    public static UserDao RequestDtoToDao(UserRequestDto userRequestDto){
        return UserDao.builder()
                .username(userRequestDto.getUsername())
                .password(userRequestDto.getPassword())
                .build();
    }
}
