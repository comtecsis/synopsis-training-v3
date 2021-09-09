package ws.synopsis.training.beans.request;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import ws.synopsis.training.beans.request.LoginRequest;

import java.util.Collection;

public class SecurityRequest extends UsernamePasswordAuthenticationToken
{
    private final LoginRequest request;

    private static final long serialVersionUID = -1389274041335460575L;

    public SecurityRequest(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities,
                           LoginRequest request)
    {
        super(principal, credentials, authorities);
        this.request = request;
    }

    public SecurityRequest(Object principal, Object credentials, LoginRequest request)
    {
        super(principal, credentials);
        this.request = request;
    }

    public LoginRequest getRequest()
    {
        return request;
    }

}
