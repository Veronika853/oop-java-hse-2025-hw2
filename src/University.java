import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class University {
    private ArrayList<Course> courses;
    private HashMap<Integer, Student> studentDirectory;
    private HashMap<String, Department> departments;

    public University() {
        courses = new ArrayList<>();
        studentDirectory = new HashMap<>();
        departments = new HashMap<>();
    }

    public void addDepartment(Department dept) {
        departments.put(dept.getName(), dept);
        System.out.println("Кафедра \"" + dept.getName() + "\" добавлена.");
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public void addCourseToDept(Department dept, Course c) {
        if (dept == null || !departments.containsValue(dept)) {
            System.out.println("Кафедра \"" + (dept != null ? dept.getName() : "null") + "\" не найдена.");
            return;
        }
        dept.addCourse(c);
    }

    public List<Course> getCoursesForDept(Department dept) {
        if (dept != null) {
            return dept.listCourses();
        } else {
            System.out.println("Кафедра \"" + dept.getName() + "\" не найдена.");
            return new ArrayList<>();
        }
    }

    public void showAllCourses() {
        if (departments.isEmpty()) {
            System.out.println("В университете пока нет кафедр.");
            return;
        }
        System.out.println("Курсы университета по кафедрам:");
        for (Department dept : departments.values()) {
            System.out.println("Кафедра: " + dept.getName());
            Professor head = dept.getHead();
            if (head != null) {
                System.out.println("Заведующий кафедры: " + head.getDetails());
            } else {
                System.out.println("Заведующий кафедры не назначен.");
            }

            List<Course> deptCourses = dept.listCourses();
            if (deptCourses.isEmpty()) {
                System.out.println("Нет курсов.");
            } else {
                for (Course c : deptCourses) {
                    c.showCourseDetails();
                }
            }
            System.out.println("---------------------------");
        }

    }

    public void registerStudent(Student s) {
        if (studentDirectory.containsKey(s.getId())) {
            System.out.println("Студент с ID " + s.getId() + " уже зарегистрирован.");
        } else {
            studentDirectory.put(s.getId(), s);
            System.out.println("Студент " + s.getDetails() + " зарегистрирован в университете.");
        }
    }

    public Student findStudentById(int id) throws StudentNotFoundException {
        Student s = studentDirectory.get(id);
        if (s == null) {
            throw new StudentNotFoundException("Студент с ID " + id + " не найден.");
        }
        System.out.println("Информация о студенте: " + s.getDetails());
        return s;
    }
}
