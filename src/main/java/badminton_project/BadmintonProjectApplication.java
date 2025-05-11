package badminton_project;

import lombok.RequiredArgsConstructor;
import badminton_project.module.users.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class BadmintonProjectApplication implements CommandLineRunner {

    private final UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(BadmintonProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userService.initAdminUser();
    }
} 