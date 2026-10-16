package ir.maktabsharif.service.book;

import ir.maktabsharif.command.BookCommand;
import ir.maktabsharif.dao.BookDao;
import ir.maktabsharif.dto.book.BookRequestDto;
import ir.maktabsharif.dto.book.BookResponseDto;
import ir.maktabsharif.exception.InvalidRequestException;
import ir.maktabsharif.repository.book.BookRepositoryImpl;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookRepositoryImpl bookRepository;
    private BookCommand bookCommand;


    public BookServiceImpl(BookRepositoryImpl bookRepository) {
        this.bookRepository = bookRepository;
        this.bookCommand = new BookCommand();
    }


    @Override
    public BookResponseDto save(BookRequestDto bookRequestDto) {
        try {
            if (bookRequestDto == null || bookRequestDto.title() == null || bookRequestDto.author() == null || bookRequestDto.publicationYear() == null) {
                throw new InvalidRequestException("Book data invalid");
            }
            BookDao bookDao = BookDao.builder()
                    .title(bookRequestDto.title())
                    .author(bookRequestDto.author())
                    .publicationYear(bookRequestDto.publicationYear())
                    .build();

            return bookCommand.DaoToDtoResponse(bookRepository.create(bookDao));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BookResponseDto update(BookRequestDto bookRequestDto) {
        try {
            BookDao bookDao = BookDao.builder()
                    .title(bookRequestDto.title())
                    .author(bookRequestDto.author())
                    .publicationYear(bookRequestDto.publicationYear())
                    .build();

            return bookCommand.DaoToDtoResponse(bookRepository.update(bookDao));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            bookRepository.delete(id);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BookResponseDto read(BookRequestDto bookRequestDto) {
        try {
            BookDao bookDao = BookDao.builder()
                    .title(bookRequestDto.title())
                    .author(bookRequestDto.author())
                    .publicationYear(bookRequestDto.publicationYear())
                    .build();

            return bookCommand.DaoToDtoResponse(bookRepository.read(bookDao.getId()));

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<BookResponseDto> findAll() {
        try {
            List<BookDao> bookDaos = bookRepository.findAll();

            return bookDaos.stream().map(t -> bookCommand.DaoToDtoResponse(t)).toList();

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
