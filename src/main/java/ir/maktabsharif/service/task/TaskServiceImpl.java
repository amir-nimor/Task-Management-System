package ir.maktabsharif.service.task;

import ir.maktabsharif.command.TaskCommand;
import ir.maktabsharif.dao.TaskDao;
import ir.maktabsharif.dto.task.TaskRequestDto;
import ir.maktabsharif.dto.task.TaskResponseDto;
import ir.maktabsharif.dto.user.UserRequestDto;
import ir.maktabsharif.repository.task.TaskRepositoryImpl;

import java.util.List;

public class TaskServiceImpl implements TaskService{

    private TaskRepositoryImpl taskRepository;
    private TaskCommand taskCommand;


    public TaskServiceImpl(TaskRepositoryImpl taskRepository){
        this.taskRepository = taskRepository;
        this.taskCommand = new TaskCommand();
    }


    @Override
    public TaskResponseDto save(TaskRequestDto taskRequestDto) {
        try {
            TaskDao taskDao = TaskDao.builder()
                    .title(taskRequestDto.getTitle())
                    .description(taskRequestDto.getDescription())
                    .userDao(taskRequestDto.getUserDao())
                    .build();

            return taskCommand.DaoToDtoResponse(taskRepository.create(taskDao));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TaskResponseDto update(TaskRequestDto taskRequestDto) {
        try {
            TaskDao taskDao = TaskDao.builder()
                    .title(taskRequestDto.getTitle())
                    .description(taskRequestDto.getDescription())
                    .userDao(taskRequestDto.getUserDao())
                    .build();

            return taskCommand.DaoToDtoResponse(taskRepository.update(taskDao));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TaskResponseDto delete(TaskRequestDto taskRequestDto) {
        try {
            TaskDao taskDao = TaskDao.builder()
                    .title(taskRequestDto.getTitle())
                    .description(taskRequestDto.getDescription())
                    .userDao(taskRequestDto.getUserDao())
                    .build();

            return TaskResponseDto.builder()
                    .id(taskRepository.delete(taskDao.getId()))
                    .build();

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TaskResponseDto read(TaskRequestDto taskRequestDto) {
        try {
            TaskDao taskDao = TaskDao.builder()
                    .title(taskRequestDto.getTitle())
                    .description(taskRequestDto.getDescription())
                    .userDao(taskRequestDto.getUserDao())
                    .build();

            return taskCommand.DaoToDtoResponse(taskRepository.read(taskDao.getId()));

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TaskResponseDto> findAll() {
        try {
            List<TaskDao> taskDaos = taskRepository.findAll();

            return taskDaos.stream().map(t -> taskCommand.DaoToDtoResponse(t)).toList();

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
