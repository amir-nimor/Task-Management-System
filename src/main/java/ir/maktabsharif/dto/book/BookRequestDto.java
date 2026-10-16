package ir.maktabsharif.dto.book;

import ir.maktabsharif.dao.UserDao;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BookRequestDto {


    private String title;
    private String author;
    private String publicationYear;


}
