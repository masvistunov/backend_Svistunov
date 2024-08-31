package t1.debute.techradar.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import t1.debute.techradar.entity.UserRole;
import t1.debute.techradar.rest.dto.UserDTO;
import t1.debute.techradar.service.UserServiceImpl;

@RestController
@CrossOrigin("http://localhost:5174")
@RequiredArgsConstructor
@Slf4j
public class UserRestController {
    @Autowired
    UserServiceImpl userService;
    @GetMapping("/user")
    public UserDTO curentUser(@AuthenticationPrincipal UserDetails userDetails){
        log.info("getUser"+ userDetails);

        if(userDetails==null) return UserDTO.builder().username("").role(UserRole.USER.valueOf("NONAuthenticated")).build();
        else return UserDTO.builder().username(userDetails.getUsername()).role(UserRole.valueOf(userDetails.getAuthorities().toArray()[0].toString().substring(5))).build();
    }
    @PostMapping("/user")
    public void createUser(@RequestBody UserDTO user){
        log.info("createUser" + user);
        userService.createUser(user);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestBody UserDTO user){
        log.info("deleteUser" + user);
        userService.deleteUser(user);
    }
}
