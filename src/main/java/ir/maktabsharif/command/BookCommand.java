package ir.maktabsharif.command;

import ir.maktabsharif.dao.BookDao;
import ir.maktabsharif.dto.book.BookRequestDto;
import ir.maktabsharif.dto.book.BookResponseDto;

public class BookCommand implements Commandable<BookDao, BookRequestDto, BookResponseDto> {


    @Override
    public BookDao DtoRequestToDao(BookRequestDto bookRequestDto) {
        return BookDao.builder()
                .title(bookRequestDto.title())
                .build();
    }

    @Override
    public BookResponseDto DaoToDtoResponse(BookDao bookDao) {
        return new BookResponseDto(bookDao.getId(), bookDao.getTitle(), bookDao.getAuthor(), bookDao.getPublicationYear());
    }


}
