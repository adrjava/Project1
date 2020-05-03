package aplicatie.model;


import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private String userName;
    private String password;
    private String email;
}
