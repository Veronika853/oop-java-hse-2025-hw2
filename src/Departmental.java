import java.util.List;

public interface Departmental {
    void addCourse(Course c);
    void removeCourse(Course c);
    List<Course> listCourses();
}
