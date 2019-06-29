import java.util.Objects;

public class Plant   {
    String id;

    String getID()   {
        return id;
    }

    @Override
    public int hashCode()   {
        return Objects.hash(getID());
    }
}