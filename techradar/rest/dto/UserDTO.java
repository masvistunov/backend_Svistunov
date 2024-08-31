package t1.debute.techradar.rest.dto;

import lombok.Builder;
import lombok.Data;
import t1.debute.techradar.entity.UserRole;

@Data
@Builder
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private UserRole role;
}