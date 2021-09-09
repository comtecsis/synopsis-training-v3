package ws.synopsis.training.enumerations;

import ws.synopsis.training.beans.base.TrainingResponse;
import ws.synopsis.training.beans.base.TrainingStatus;

public enum AccessCodeEnum
{
    // @formatter:off
    OK(AccessContext.LOGIC, 0, "Consulta exitosa."),
    NOT_AUTHENTICATED(AccessContext.LOGIC, 1, "No se encuentra autenticado."),
    MIMETYPE_INVALID(AccessContext.LOGIC, 2, "El tipo de dato es inválido."),
    STORE_PROCEDURE(AccessContext.LOGIC, 3, "Error inesperado."),
    EXIST_EMAIL(AccessContext.LOGIC, 5, "Email ya registrado."),
    EXIST_PHONE(AccessContext.LOGIC, 6, "Celular ya registrado."),
    EXIST_FIELD(AccessContext.LOGIC, 7, "Uno de los datos ya está registrado."),
    FAIL(AccessContext.LOGIC, 1000, "Error inesperado."),

    RESOURCE_NOT_EXIST(AccessContext.STORE_PROCEDURE, 1, "Recurso no existe.");
    // @formatter:on

    private AccessContext context;
    private TrainingStatus status;

    AccessCodeEnum(AccessContext context, Integer index, String message)
    {
        this.status = new TrainingStatus(context.getCode(index), message);
        this.context = context;
    }

    public AccessContext getContext()
    {
        return context;
    }

    public String getCode()
    {
        return this.status.getCode();
    }

    public String getMessage()
    {
        return this.status.getMessage();
    }

    public boolean isCode(String code)
    {
        return this.getCode().equals(code);
    }

    public TrainingStatus status()
    {
        return this.status;
    }

    public <T> TrainingResponse<T> createResponse(T data)
    {
        return new TrainingResponse<>(new TrainingStatus(this.getCode(), this.getMessage()), data);
    }

    public <T> TrainingResponse<T> createResponse()
    {
        return new TrainingResponse<>(new TrainingStatus(this.getCode(), this.getMessage()));
    }

}
