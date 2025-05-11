package badminton_project.module.users.controller;

import badminton_project.config.response.DefaultRes;
import badminton_project.config.response.ResponseMessage;
import badminton_project.config.response.StatusCode;
import badminton_project.module.users.dto.request.LoginRequest;
import badminton_project.module.users.dto.response.LoginResponse;
import badminton_project.module.users.service.UserService;
import badminton_project.utils.ClientUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ClientUtils.VERSION + "/auth")
@Tag(name = "01. Authentication", description = "Authentication APIs")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/login")
    @Operation(summary = "Login to get JWT token")
    public ResponseEntity<DefaultRes<LoginResponse>> login(@Valid @RequestBody LoginRequest request) {
        return new ResponseEntity<>(DefaultRes.res(StatusCode.OK, ResponseMessage.SUCCESS, userService.login(request)), HttpStatus.OK);

    }
} 