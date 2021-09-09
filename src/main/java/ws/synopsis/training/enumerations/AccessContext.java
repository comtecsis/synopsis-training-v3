package ws.synopsis.training.enumerations;

public enum AccessContext
{
    // @formatter:off
    LOGIC(0),
    STORE_PROCEDURE(1000),
    EXTERNAL_SERVICE(2000);
    // @formatter:on

    private Integer base;

    AccessContext(Integer base)
    {
        this.base = base;
    }

    public String getCode(Integer index)
    {
        return String.format("%04d", this.base + index);
    }
}
