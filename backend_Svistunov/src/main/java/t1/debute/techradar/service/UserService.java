package t1.debute.techradar.service;

import t1.debute.techradar.rest.dto.UserDTO;

public interface UserService {
    UserDTO createUser(UserDTO user);
    void deleteUser(UserDTO user);

}
