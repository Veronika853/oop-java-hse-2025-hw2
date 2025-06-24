import java.util.ArrayList;
import java.util.HashMap;

public class University {
    private ArrayList<Course> courses;
    private HashMap<Integer, Student> studentDirectory;

    public University() {
        courses = new ArrayList<>();
        studentDirectory = new HashMap<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public void showAllCourses() {
        System.out.println("Университетские курсы:");
        for (Course course: courses) {
            course.showCourseDetails();
            System.out.println("--------------------------");
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
