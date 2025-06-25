import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Класс, представляющий университет, управляющий курсами, кафедрами и студентами.
 * Хранит списки курсов, студентов и кафедр, предоставляет методы для их добавления,
 * удаления, поиска и отображения информации.
 */
public class University {
    private final ArrayList<Course> courses;
    private final HashMap<Integer, Student> studentDirectory;
    private final HashMap<String, Department> departments;

    /**
     * Создаёт новый университет с пустыми списками курсов, студентов и кафедр.
     */
    public University() {
        courses = new ArrayList<>();
        studentDirectory = new HashMap<>();
        departments = new HashMap<>();
    }

    /**
     * Добавляет кафедру в университет.
     *
     * @param dept кафедра для добавления
     */
    public void addDepartment(Department dept) {
        if (dept == null) {
            System.out.println("Ошибка: Кафедра не может быть null.");
            return;
        }
        departments.put(dept.getName(), dept);
        System.out.println("Кафедра \"" + dept.getName() + "\" добавлена.");
    }

    /**
     * Добавляет курс в университет.
     *
     * @param course курс для добавления
     */
    public void addCourse(Course course) {
        courses.add(course);
    }

    /**
     * Удаляет курс из университета.
     *
     * @param course курс для удаления
     */
    public void removeCourse(Course course) {
        courses.remove(course);
    }

    /**
     * Добавляет курс на указанную кафедру, если кафедра существует в университете.
     *
     * @param dept кафедра, на которую добавляется курс
     * @param c    курс для добавления
     */
    public void addCourseToDept(Department dept, Course c) {
        if (dept == null || !departments.containsValue(dept)) {
            System.out.println("Кафедра \"" + (dept != null ? dept.getName() : "null") + "\" не найдена.");
            return;
        }
        dept.addCourse(c);
    }

    /**
     * Возвращает список курсов для указанной кафедры.
     *
     * @param dept кафедра, для которой запрашиваются курсы
     * @return список курсов кафедры или пустой список, если кафедра не найдена
     */
    public List<Course> getCoursesForDept(Department dept) {
        if (dept == null) {
            System.out.println("Кафедра \"null\" не найдена.");
            return new ArrayList<>();
        }
        return dept.listCourses();
    }

    /**
     * Выводит информацию о всех курсах университета, сгруппированных по кафедрам.
     * Для каждой кафедры отображается её название, заведующий и подробности курсов.
     * Также выводятся курсы, не привязанные к кафедрам.
     */
    public void showAllCourses() {
        if (departments.isEmpty()) {
            System.out.println("В университете пока нет кафедр.");
            return;
        }
        System.out.println("Курсы университета по кафедрам:");
        for (Department dept : departments.values()) {
            System.out.println("Кафедра: " + dept.getName());
            Professor head = dept.getHead();
            System.out.println("Заведующий кафедры: " + (head != null ? head.getDetails() : "не назначен"));
            List<Course> deptCourses = getCoursesForDept(dept);
            if (deptCourses.isEmpty()) {
                System.out.println("Нет курсов.");
            } else {
                for (Course c : deptCourses) {
                    c.showCourseDetails();
                }
            }
            System.out.println("---------------------------");
        }
        System.out.println("Курсы без кафедры:");
        boolean hasOrphanCourses = false;
        for (Course c : courses) {
            boolean foundInDept = false;
            for (Department dept : departments.values()) {
                if (getCoursesForDept(dept).contains(c)) {
                    foundInDept = true;
                    break;
                }
            }
            if (!foundInDept) {
                c.showCourseDetails();
                hasOrphanCourses = true;
            }
        }
        if (!hasOrphanCourses) {
            System.out.println("Нет курсов без кафедры.");
        }
    }

    /**
     * Регистрирует студента в университете.
     * Если студент с таким ID уже зарегистрирован, выводится сообщение.
     *
     * @param s студент для регистрации
     */
    public void registerStudent(Student s) {
        if (studentDirectory.containsKey(s.getId())) {
            System.out.println("Студент с ID " + s.getId() + " уже зарегистрирован.");
        } else {
            studentDirectory.put(s.getId(), s);
            System.out.println("Студент " + s.getDetails() + " зарегистрирован в университете.");
        }
    }

    /**
     * Находит студента по идентификатору.
     *
     * @param id идентификатор студента
     * @return найденный студент
     * @throws StudentNotFoundException если студент с указанным ID не найден
     */
    public Student findStudentById(int id) throws StudentNotFoundException {
        Student s = studentDirectory.get(id);
        if (s == null) {
            throw new StudentNotFoundException("Студент с ID " + id + " не найден.");
        }
        System.out.println("Информация о студенте: " + s.getDetails());
        return s;
    }
}