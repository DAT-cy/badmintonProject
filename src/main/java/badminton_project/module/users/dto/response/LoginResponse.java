package badminton_project.module.users.dto.response;

import badminton_project.module.users.entity.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginResponse {
    private String token;
    private String username;
    private Role role;
} 