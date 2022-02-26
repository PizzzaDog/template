package by.andersen.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    private Long id;
    private String username;
    private String password;

}
