import java.util.List;

public interface Schedulable {

    void scheduleEvent(String description, String dateTime);
    List<Event> getSchedule();
}
