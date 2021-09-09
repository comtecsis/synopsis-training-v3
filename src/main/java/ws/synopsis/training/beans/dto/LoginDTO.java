package ws.synopsis.training.beans.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import ws.synopsis.security.config.UserWrapper;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class LoginDTO
{

    private String sessionId;
    private String email;
    private String name;
    private String phone;
    private Boolean existImage;
    private List<UserRoleDTO> roles;

    public LoginDTO()
    {
    }

    public LoginDTO(UserWrapper source)
    {
        BeanUtils.copyProperties(source, this, "sessionId", "roles");
        this.setRoles(source.getRoles().stream().map( role -> new UserRoleDTO(role)).collect(Collectors.toList()));
    }
}
