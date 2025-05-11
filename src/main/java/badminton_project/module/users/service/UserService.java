package badminton_project.module.users.service;

import badminton_project.module.users.dto.request.LoginRequest;
import badminton_project.module.users.dto.request.SignUpRequest;
import badminton_project.module.users.dto.response.LoginResponse;

public interface UserService {
    LoginResponse login(LoginRequest request);
    void initAdminUser();

    Boolean signUp(SignUpRequest request);
}