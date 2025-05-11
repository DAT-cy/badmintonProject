package badminton_project.module.users.service.impl;

import badminton_project.config.response.CommonException;
import badminton_project.config.response.ErrorCode;
import badminton_project.config.app.JwtService;
import badminton_project.module.users.dto.request.LoginRequest;
import badminton_project.module.users.dto.response.LoginResponse;
import badminton_project.module.users.entity.Role;
import badminton_project.module.users.entity.User;
import badminton_project.module.users.repository.UserMapper;
import badminton_project.module.users.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponse login(LoginRequest request) {
        log.info("Attempting login for user: {}", request.getUsername());

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );

            User user = (User) authentication.getPrincipal();

            String jwtToken = jwtService.generateToken(user);

            log.info("User logged in successfully: {}", request.getUsername());
            return LoginResponse.builder()
                    .username(user.getUsername())
                    .token(jwtToken)
                    .role(user.getRole())
                    .build();
        } catch (AccountExpiredException | DisabledException e) {
            throw new CommonException(ErrorCode.ACCOUNT_DEACTIVATE);
        }
        catch (Exception e) {
            throw new CommonException(ErrorCode.WRONG_PASSWORD);
        }
    }

    @Override
    public void initAdminUser() {
        if (userMapper.countAdminUsers() == 0) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setEnable(true);
            admin.setIsDeleted(false);
            admin.setRole(Role.ROLE_ADMIN);
            userMapper.insertUser(admin);
            User user = new User();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("user"));
            user.setEnable(true);
            user.setIsDeleted(false);
            user.setRole(Role.ROLE_USER);
            userMapper.insertUser(user);
        }
    }
} 