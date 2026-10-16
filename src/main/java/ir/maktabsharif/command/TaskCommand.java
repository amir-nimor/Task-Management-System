package ir.maktabsharif.command;

import ir.maktabsharif.dao.BookDao;
import ir.maktabsharif.dto.task.TaskRequestDto;
import ir.maktabsharif.dto.task.TaskResponseDto;

public class TaskCommand implements Commandable<BookDao,TaskRequestDto,TaskResponseDto> {




    @Override
    public BookDao DtoRequestToDao(TaskRequestDto taskRequestDto) {
                return BookDao.builder()
                .title(taskRequestDto.getTitle())
                .userDao(taskRequestDto.getUserDao())
                .description(taskRequestDto.getDescription())
                .build();
    }

    @Override
    public TaskResponseDto DaoToDtoResponse(BookDao bookDao) {
        return TaskResponseDto.builder()
                .title(bookDao.getTitle())
                .description(bookDao.getDescription())
                .creatAt(bookDao.getCreatAt())
                .userId(bookDao.getId())
                .build();
    }


}
