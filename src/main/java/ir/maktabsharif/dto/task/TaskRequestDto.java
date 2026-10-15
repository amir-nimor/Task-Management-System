package ir.maktabsharif.dto.task;

import ir.maktabsharif.dao.UserDao;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TaskRequestDto {


    private String title;

    private String description;

    private UserDao userDao;


}
