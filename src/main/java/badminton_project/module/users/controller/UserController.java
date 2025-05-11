package badminton_project.module.users.controller;

import badminton_project.config.response.DefaultRes;
import badminton_project.config.response.ResponseMessage;
import badminton_project.config.response.StatusCode;
import badminton_project.utils.ClientUtils;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ClientUtils.VERSION + "/user/users")
@Tag(name = "02. Users")
@RequiredArgsConstructor
public class UserController {

    @GetMapping
    public ResponseEntity<DefaultRes<String>> test() {
        return new ResponseEntity<>(DefaultRes.res(StatusCode.OK, ResponseMessage.SUCCESS, "Test"), HttpStatus.OK);

    }
}
