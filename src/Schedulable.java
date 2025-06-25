import java.util.List;

/**
 * Интерфейс для объектов, поддерживающих управление расписанием событий.
 * Определяет методы для добавления событий в расписание и получения их списка.
 */
public interface Schedulable {

    /**
     * Планирует новое событие, добавляя его в расписание.
     *
     * @param description описание события
     * @param dateTime    дата и время события в формате строки
     */
    void scheduleEvent(String description, String dateTime);

    /**
     * Возвращает список всех запланированных событий.
     *
     * @return список событий
     */
    List<Event> getSchedule();
}