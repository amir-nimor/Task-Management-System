package ir.maktabsharif.service.book;

import ir.maktabsharif.dto.book.BookRequestDto;
import ir.maktabsharif.dto.book.BookResponseDto;

import java.util.List;

public interface BookService {


    BookResponseDto save(BookRequestDto bookRequestDto);

    BookResponseDto update(BookRequestDto bookRequestDto);

    void delete(Integer id);

    BookResponseDto read(BookRequestDto bookRequestDto);

    List<BookResponseDto> findAll();

}
