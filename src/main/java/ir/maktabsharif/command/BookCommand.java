package ir.maktabsharif.command;

import ir.maktabsharif.dao.BookDao;
import ir.maktabsharif.dto.book.BookRequestDto;
import ir.maktabsharif.dto.book.BookResponseDto;

public class BookCommand implements Commandable<BookDao, BookRequestDto, BookResponseDto> {


    @Override
    public BookDao DtoRequestToDao(BookRequestDto bookRequestDto) {
        return BookDao.builder()
                .title(bookRequestDto.getTitle())
                .author(bookRequestDto.getAuthor())
                .publicationYear(bookRequestDto.getPublicationYear())
                .build();
    }

    @Override
    public BookResponseDto DaoToDtoResponse(BookDao bookDao) {
        return BookResponseDto.builder()
                .title(bookDao.getTitle())
                .author(bookDao.getAuthor())
                .publicationYear(bookDao.getPublicationYear())
                .build();
    }


}
