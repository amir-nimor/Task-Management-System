package ir.maktabsharif.dao;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "Tasks")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaskDao extends BaseModel<Integer>{

    private String title;

    private String description;

    @CreationTimestamp
    private LocalDateTime creatAt;


    @ManyToOne
    private UserDao userDao;


}
