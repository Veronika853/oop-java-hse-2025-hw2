import java.util.LinkedList;
import java.util.List;

/**
 * Класс, представляющий профессора университета.
 * Наследуется от {@link UniversityMember} и реализует интерфейс {@link Schedulable}
 * для управления расписанием событий профессора.
 */
public class Professor extends UniversityMember implements Schedulable {
    private final Department department;
    private final LinkedList<Event> schedule = new LinkedList<>();

    /**
     * Создаёт нового профессора с указанным именем, идентификатором и кафедрой.
     *
     * @param name       имя профессора
     * @param id         уникальный идентификатор профессора
     * @param department кафедра, к которой прикреплён профессор, может быть null
     */
    public Professor(String name, int id, Department department) {
        super(name, id);
        this.department = department;
    }

    /**
     * Планирует новое событие для профессора, добавляя его в расписание.
     * Выводит сообщение о запланированном событии в консоль.
     *
     * @param description описание события
     * @param dateTime    дата и время события в формате строки
     */
    @Override
    public void scheduleEvent(String description, String dateTime) {
        schedule.add(new Event(description, dateTime));
        System.out.println("Профессор " + name + " запланировал событие: \"" + description + "\" на " + dateTime);
    }

    /**
     * Возвращает список всех запланированных событий профессора.
     *
     * @return список событий
     */
    @Override
    public List<Event> getSchedule() {
        return schedule;
    }

    /**
     * Возвращает подробную информацию о профессоре, включая идентификатор, имя и название кафедры.
     *
     * @return строка с информацией о профессоре
     */
    @Override
    public String getDetails() {
        return "ID преподавателя: " + id + ", Имя: " + name + ", кафедра: " + department.getName();
    }
}
