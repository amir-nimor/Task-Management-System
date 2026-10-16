package ir.maktabsharif.service.book;

import ir.maktabsharif.dto.book.BookRequestDto;
import ir.maktabsharif.dto.book.BookResponseDto;

import java.util.List;

public interface BookService {


    BookResponseDto save(BookRequestDto taskRequestDto);
    BookResponseDto update(BookRequestDto taskRequestDto);
    BookResponseDto delete(BookRequestDto taskRequestDto);
    BookResponseDto read(BookRequestDto taskRequestDto);
    List<BookResponseDto> findAll();

}
