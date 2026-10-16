package ir.maktabsharif.dto.user;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRequestDto {

    private Integer id;

    private String username;

    private String password;


}
