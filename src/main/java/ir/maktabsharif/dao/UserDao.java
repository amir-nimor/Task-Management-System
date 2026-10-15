package ir.maktabsharif.dao;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDao extends BaseModel<Integer>{

    @Column(unique = true)
    private String username;

    private String password;


}
