package ir.maktabsharif.dto.book;

import ir.maktabsharif.dao.UserDao;
import lombok.*;

public record BookRequestDto(String title, String author, String publicationYear) {
}
