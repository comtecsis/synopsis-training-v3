package ws.synopsis.training.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import ws.synopsis.security.beans.domain.User;
import ws.synopsis.security.config.JwtAuthenticationException;
import ws.synopsis.security.config.SecurityToken;
import ws.synopsis.security.config.UserRole;
import ws.synopsis.security.config.UserWrapper;
import ws.synopsis.training.beans.request.LoginRequest;
import ws.synopsis.training.beans.request.SecurityRequest;

import java.util.Arrays;
import java.util.List;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider
{

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {

        SecurityRequest request = (SecurityRequest) authentication;
        LoginRequest login = request.getRequest();
        String username = login.getEmail();
        //AccessResult<User> status = loginDAO.login(login);

        if ("admin".equals(username))
        {
            User user = User.builder().role("ADMIN").name("Elvis Perez").build();
            UserWrapper userInfo = new UserWrapper(user);
            List<UserRole> roles = Arrays.asList(new UserRole(user.getRole()));
            return new SecurityToken(username, null, roles, userInfo);
        }
        else
        {
            throw new JwtAuthenticationException("No se identifico correctamente");
        }
    }

    @Override
    public boolean supports(Class<?> authentication)
    {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}
