package ir.maktabsharif.dto.task;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaskResponseDto {


    private Integer id;
    private String title;

    private String description;


    private LocalDateTime creatAt;

    private Integer userId;
}
