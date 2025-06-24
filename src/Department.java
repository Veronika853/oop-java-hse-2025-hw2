import java.util.LinkedList;
import java.util.List;

public class Department implements Departmental {
    private String name;
    private Professor head;
    private LinkedList<Course> courses;

    public Department(String name, Professor head) {
        this.name = name;
        this.head = head;
        this.courses = new LinkedList<>();
    }

    @Override
    public void addCourse(Course c) {
        courses.add(c);
        System.out.println("Курс \"" + c.getCourseName() + "\" добавлен в кафедру \"" + name + "\".");
    }

    @Override
    public void removeCourse(Course c) {
        if (courses.remove(c)) {
            System.out.println("Курс \"" + c.getCourseName() + "\" удалён из кафедры \"" + name + "\".");
        } else {
            System.out.println("Курс \"" + c.getCourseName() + "\" не найден в кафедре \"" + name + "\".");
        }
    }

    @Override
    public List<Course> listCourses() {
        return courses;
    }

    public String getName() {
        return name;
    }

    public Professor getHead() {
        return head;
    }
}
