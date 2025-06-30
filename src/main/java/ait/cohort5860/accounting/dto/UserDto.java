package ait.cohort5860.accounting.dto;


import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private Set<String> roles;
}
