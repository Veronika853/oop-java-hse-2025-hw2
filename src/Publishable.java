import java.util.List;

public interface Publishable {
    void publish(String message);
    List<String> getFeed();
}
