package ws.synopsis.training.service;

import ws.synopsis.training.beans.base.TrainingResponse;
import ws.synopsis.training.beans.base.TrainingStatus;
import ws.synopsis.training.beans.dto.LoginDTO;
import ws.synopsis.training.beans.request.LoginRequest;
import ws.synopsis.training.beans.request.LogoffRequest;
import ws.synopsis.training.exception.AccessLogicException;

public interface LoginService
{

    public TrainingResponse<LoginDTO> login(LoginRequest login) throws AccessLogicException;

    public TrainingStatus logout(LogoffRequest request);
}
