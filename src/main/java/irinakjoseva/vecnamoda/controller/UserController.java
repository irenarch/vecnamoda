package irinakjoseva.vecnamoda.controller;

import irinakjoseva.vecnamoda.dto.request.UserRequestDto;
import irinakjoseva.vecnamoda.dto.response.UserResponseDto;
import irinakjoseva.vecnamoda.dto.mapper.UserMapper;
import irinakjoseva.vecnamoda.model.User;
import irinakjoseva.vecnamoda.service.UserService;
import irinakjoseva.vecnamoda.service.exceptions.UserAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("api/users")
public class UserController {

    //    @Autowired
    private final UserService userService;

    //    @Autowired
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping({"/hello"})
    public ResponseEntity<String> firstPage() {
        return ResponseEntity.ok("Hello world");
    }

    @PostMapping(value = "/register")
    public ResponseEntity<UserResponseDto> save(@RequestBody @Valid UserRequestDto userPostDto) throws UserAlreadyExistsException {
        return ResponseEntity.ok(userService.register(userPostDto));
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<UserResponseDto> getByUsername(@PathVariable("username") String username) {
        UserResponseDto userGetDto = this.userService.getByUsername(username);
        return ResponseEntity.ok(userGetDto);
    }

    @GetMapping(value = "/authenticated")
    public ResponseEntity<UserResponseDto> getAuthenticatedUser(Authentication authentication) {
        User user = ((HashMap<String, User>) authentication.getDetails()).get("user");
        return ResponseEntity.ok(this.userMapper.toResponseDto(user));
    }


    // ??????????????
//    @DeleteMapping(value = "/delete/{id}")
//    @PreAuthorize("hasAuthority(" + User.Role.ADMIN ")")
//    public ResponseEntity delete(@PathVariable ("id") Long id) {
//        this.userService.delete(id);
//        return ResponseEntity.ok().build();
//    }

}
