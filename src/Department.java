import java.util.LinkedList;
import java.util.List;

/**
 * Класс, представляющий кафедру университета.
 * Реализует интерфейс {@link Departmental} для управления курсами кафедры.
 */
public class Department implements Departmental {
    private final String name;
    private Professor head;
    private final LinkedList<Course> courses;

    /**
     * Создаёт новую кафедру с указанным названием и заведующим.
     *
     * @param name название кафедры
     * @param head заведующий кафедрой, может быть null
     */
    public Department(String name, Professor head) {
        this.name = name;
        this.head = head;
        this.courses = new LinkedList<>();
    }

    /**
     * Добавляет курс на кафедру и выводит сообщение о добавлении.
     *
     * @param c курс для добавления
     */
    @Override
    public void addCourse(Course c) {
        courses.add(c);
        System.out.println("Курс \"" + c.getCourseName() + "\" добавлен на кафедру \"" + name + "\".");
    }

    /**
     * Удаляет курс из кафедры и выводит сообщение об удалении.
     * Если курс не найден, выводится соответствующее сообщение.
     *
     * @param c курс для удаления
     */
    @Override
    public void removeCourse(Course c) {
        if (courses.remove(c)) {
            System.out.println("Курс \"" + c.getCourseName() + "\" удалён из кафедры \"" + name + "\".");
        } else {
            System.out.println("Курс \"" + c.getCourseName() + "\" не найден в кафедре \"" + name + "\".");
        }
    }

    /**
     * Возвращает список всех курсов кафедры.
     *
     * @return список курсов
     */
    @Override
    public List<Course> listCourses() {
        return courses;
    }

    /**
     * Возвращает название кафедры.
     *
     * @return название кафедры
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает заведующего кафедрой.
     *
     * @return заведующий кафедрой, может быть null
     */
    public Professor getHead() {
        return head;
    }

    /**
     * Устанавливает нового заведующего кафедрой.
     *
     * @param head новый заведующий кафедрой
     */
    public void setHead(Professor head) {
        this.head = head;
    }
}
