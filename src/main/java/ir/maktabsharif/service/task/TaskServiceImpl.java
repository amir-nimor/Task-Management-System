package ir.maktabsharif.service.task;

import ir.maktabsharif.command.TaskCommand;
import ir.maktabsharif.dao.BookDao;
import ir.maktabsharif.dto.task.TaskRequestDto;
import ir.maktabsharif.dto.task.TaskResponseDto;
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
            BookDao bookDao = BookDao.builder()
                    .title(taskRequestDto.getTitle())
                    .description(taskRequestDto.getDescription())
                    .userDao(taskRequestDto.getUserDao())
                    .build();

            return taskCommand.DaoToDtoResponse(taskRepository.create(bookDao));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TaskResponseDto update(TaskRequestDto taskRequestDto) {
        try {
            BookDao bookDao = BookDao.builder()
                    .title(taskRequestDto.getTitle())
                    .description(taskRequestDto.getDescription())
                    .userDao(taskRequestDto.getUserDao())
                    .build();

            return taskCommand.DaoToDtoResponse(taskRepository.update(bookDao));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TaskResponseDto delete(TaskRequestDto taskRequestDto) {
        try {
            BookDao bookDao = BookDao.builder()
                    .title(taskRequestDto.getTitle())
                    .description(taskRequestDto.getDescription())
                    .userDao(taskRequestDto.getUserDao())
                    .build();

            return TaskResponseDto.builder()
                    .id(taskRepository.delete(bookDao.getId()))
                    .build();

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TaskResponseDto read(TaskRequestDto taskRequestDto) {
        try {
            BookDao bookDao = BookDao.builder()
                    .title(taskRequestDto.getTitle())
                    .description(taskRequestDto.getDescription())
                    .userDao(taskRequestDto.getUserDao())
                    .build();

            return taskCommand.DaoToDtoResponse(taskRepository.read(bookDao.getId()));

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TaskResponseDto> findAll() {
        try {
            List<BookDao> bookDaos = taskRepository.findAll();

            return bookDaos.stream().map(t -> taskCommand.DaoToDtoResponse(t)).toList();

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
