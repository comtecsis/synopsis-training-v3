package ws.synopsis.training.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ws.synopsis.security.config.JwtTokenProvider;
import ws.synopsis.security.config.SecurityToken;
import ws.synopsis.training.beans.base.TrainingResponse;
import ws.synopsis.training.beans.base.TrainingStatus;
import ws.synopsis.training.beans.dto.LoginDTO;
import ws.synopsis.training.beans.request.LoginRequest;
import ws.synopsis.training.beans.request.LogoffRequest;
import ws.synopsis.training.beans.request.SecurityRequest;
import ws.synopsis.training.enumerations.AccessCodeEnum;
import ws.synopsis.training.enumerations.AccessPropsEnum;
import ws.synopsis.training.exception.AccessLogicException;
import ws.synopsis.training.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService
{

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private Environment env;

    @Override
    public TrainingResponse<LoginDTO> login(LoginRequest login) throws AccessLogicException
    {
        TrainingResponse<LoginDTO> response = new TrainingResponse<LoginDTO>(AccessCodeEnum.OK.status());
        try
        {
            SecurityToken token = (SecurityToken) authenticationManager
                    .authenticate(new SecurityRequest(login.getEmail(), null, login));
            SecurityContextHolder.getContext().setAuthentication(token);
            LoginDTO lr = new LoginDTO(token.getUserInfo());
            String jwt = tokenProvider.generateToken(token);
            lr.setSessionId(String.format("%s %s", AccessPropsEnum.JWT_PREFIX.getString(env), jwt));
            response.setData(lr);
            return response;
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
        }
        throw new AccessLogicException(AccessCodeEnum.NOT_AUTHENTICATED);
    }

    @Override
    public TrainingStatus logout(LogoffRequest request)
    {
        return AccessCodeEnum.OK.status();
    }
}
