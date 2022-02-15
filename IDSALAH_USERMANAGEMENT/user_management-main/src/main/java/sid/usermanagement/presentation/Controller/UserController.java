package sid.usermanagement.presentation.Controller;

import sid.usermanagement.domain.data.UserD;
import sid.usermanagement.domain.data.UserR;
import sid.usermanagement.domain.service.UserService;
import sid.usermanagement.presentation.utils.Const;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // create blog user rest api
    @PostMapping
    public ResponseEntity<UserD> createUser(@RequestBody UserD userD){
        return new ResponseEntity<>(userService.createUser(userD), HttpStatus.CREATED);
    }

    // get all users rest api
    @GetMapping
    public UserR getAllUsers(
            @RequestParam(value = "pageNo", defaultValue = Const.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = Const.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = Const.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = Const.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ){
        return userService.getAllUsers(pageNo, pageSize, sortBy, sortDir);
    }

}