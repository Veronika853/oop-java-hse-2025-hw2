/**
 * Класс, представляющий событие в расписании, с описанием и датой/временем.
 * Используется для хранения информации о запланированных мероприятиях, например, лекциях или консультациях.
 */
public class Event {
    private final String description;
    private final String dateTime;

    /**
     * Создаёт новое событие с указанным описанием и датой/временем.
     *
     * @param description описание события
     * @param dateTime    дата и время события в формате строки
     */
    public Event(String description, String dateTime) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Описание события не может быть null или пустым.");
        }
        if (dateTime == null) {
            throw new IllegalArgumentException("Дата и время события не могут быть null.");
        }
        this.description = description;
        this.dateTime = dateTime;
    }


    /**
     * Возвращает описание события.
     *
     * @return описание события
     */
    public String getDescription() {
        return description;
    }

    /**
     * Возвращает дату и время события.
     *
     * @return дата и время события в формате строки
     */
    public String getDateTime() {
        return dateTime;
    }

}