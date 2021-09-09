package ws.synopsis.training.beans.dto;

import lombok.Getter;
import lombok.Setter;
import ws.synopsis.security.config.UserRole;

@Getter
@Setter
public class UserRoleDTO
{

    private String authority;

    UserRoleDTO(UserRole userRole)
    {
        this.authority = userRole.getAuthority();
    }
}
