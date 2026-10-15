package ir.maktabsharif.command;

import ir.maktabsharif.dao.TaskDao;
import ir.maktabsharif.dto.task.TaskRequestDto;
import ir.maktabsharif.dto.task.TaskResponseDto;

public class TaskCommand implements Commandable<TaskDao,TaskRequestDto,TaskResponseDto> {




    @Override
    public TaskDao DtoRequestToDao(TaskRequestDto taskRequestDto) {
                return TaskDao.builder()
                .title(taskRequestDto.getTitle())
                .userDao(taskRequestDto.getUserDao())
                .description(taskRequestDto.getDescription())
                .build();
    }

    @Override
    public TaskResponseDto DaoToDtoResponse(TaskDao taskDao) {
        return TaskResponseDto.builder()
                .title(taskDao.getTitle())
                .description(taskDao.getDescription())
                .creatAt(taskDao.getCreatAt())
                .userId(taskDao.getId())
                .build();
    }


}
