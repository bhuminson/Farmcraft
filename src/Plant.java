import java.util.Objects;

public class Plant   {
    protected String id;

    public String getID()   {
        return id;
    }

    @Override
    public int hashCode()   {
        return Objects.hash(getID());
    }
}