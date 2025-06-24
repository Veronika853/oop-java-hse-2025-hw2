import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class University {
    private ArrayList<Course> courses;
    private HashMap<Integer, Student> studentDirectory;
    private HashMap<String, LinkedList<Course>> coursesByDept;
    private HashMap<String, Department> departments;

    public University() {
        courses = new ArrayList<>();
        coursesByDept = new HashMap<>();
        studentDirectory = new HashMap<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public void addCourseToDept(String deptName, Course c) {
        LinkedList<Course> deptCourses = coursesByDept.get(deptName);
        if (deptCourses == null) {
            deptCourses = new LinkedList<>();
            coursesByDept.put(deptName, deptCourses);
        }
        deptCourses.add(c);
        System.out.println("Курс \"" + c.getCourseName() + "\" добавлен на кафедру \"" + deptName + "\".");
    }

    public List<Course> getCoursesForDept(String deptName) {
        LinkedList<Course> deptCourses = coursesByDept.get(deptName);
        if (deptCourses == null) {
            return new LinkedList<>();
        }
        return deptCourses;
    }

    public void showAllCourses() {
        System.out.println();
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
