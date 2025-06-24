public class Event {
    private String description;
    private String dateTime;

    public Event(String description, String dateTime) {
        this.description = description;
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public String getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "[" + dateTime + "] " + description;
    }
}