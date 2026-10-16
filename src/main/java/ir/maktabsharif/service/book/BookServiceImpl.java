package ir.maktabsharif.service.book;

import ir.maktabsharif.command.BookCommand;
import ir.maktabsharif.dao.BookDao;
import ir.maktabsharif.dto.book.BookRequestDto;
import ir.maktabsharif.dto.book.BookResponseDto;
import ir.maktabsharif.repository.book.BookRepositoryImpl;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookRepositoryImpl taskRepository;
    private BookCommand taskCommand;


    public BookServiceImpl(BookRepositoryImpl taskRepository){
        this.taskRepository = taskRepository;
        this.taskCommand = new BookCommand();
    }


    @Override
    public BookResponseDto save(BookRequestDto bookRequestDto) {
        try {
            BookDao bookDao = BookDao.builder()
                    .title(bookRequestDto.getTitle())
                    .publicationYear(bookRequestDto.getPublicationYear())
                    .author(bookRequestDto.getAuthor())
                    .build();

            return taskCommand.DaoToDtoResponse(taskRepository.create(bookDao));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BookResponseDto update(BookRequestDto bookRequestDto) {
        try {
            BookDao bookDao = BookDao.builder()
                    .title(bookRequestDto.getTitle())
                    .publicationYear(bookRequestDto.getPublicationYear())
                    .author(bookRequestDto.getAuthor())
                    .build();

            return taskCommand.DaoToDtoResponse(taskRepository.update(bookDao));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BookResponseDto delete(BookRequestDto bookRequestDto) {
        try {
            BookDao bookDao = BookDao.builder()
                    .title(bookRequestDto.getTitle())
                    .publicationYear(bookRequestDto.getPublicationYear())
                    .author(bookRequestDto.getAuthor())
                    .build();

            return BookResponseDto.builder()
                    .id(taskRepository.delete(bookDao.getId()))
                    .build();

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BookResponseDto read(BookRequestDto bookRequestDto) {
        try {
            BookDao bookDao = BookDao.builder()
                    .title(bookRequestDto.getTitle())
                    .publicationYear(bookRequestDto.getPublicationYear())
                    .author(bookRequestDto.getAuthor())
                    .build();

            return taskCommand.DaoToDtoResponse(taskRepository.read(bookDao.getId()));

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<BookResponseDto> findAll() {
        try {
            List<BookDao> bookDaos = taskRepository.findAll();

            return bookDaos.stream().map(t -> taskCommand.DaoToDtoResponse(t)).toList();

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
