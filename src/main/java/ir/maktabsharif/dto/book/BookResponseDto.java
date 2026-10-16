package ir.maktabsharif.dto.book;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookResponseDto {


    private Integer id;
    private String title;
    private String author;
    private String publicationYear;
}
