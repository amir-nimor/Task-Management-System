package ir.maktabsharif.service.task;

import ir.maktabsharif.dto.task.TaskRequestDto;
import ir.maktabsharif.dto.task.TaskResponseDto;
import ir.maktabsharif.dto.user.UserRequestDto;

import java.util.List;

public interface TaskService {


    TaskResponseDto save(TaskRequestDto taskRequestDto);
    TaskResponseDto update(TaskRequestDto taskRequestDto);
    TaskResponseDto delete(TaskRequestDto taskRequestDto);
    TaskResponseDto read(TaskRequestDto taskRequestDto);
    List<TaskResponseDto> findAll();

}
