package ir.maktabsharif.dao;
/**
 * Book
 * • id
 * • title
 * • author
 * • publicationYear
 */

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "Tasks")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookDao extends BaseModel<Integer> {
    private String title;
    private String author;
    private String publicationYear;
}
