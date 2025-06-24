import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            Professor prof1 = new Professor("Иван Викторович к.ф.м.н.", 1001, "Компьютерные науки");
            Professor prof2 = new Professor("Алла Ивановна к.ф.н.", 1002, "Филология");

            Course course1 = new Course("Введение в программирование", prof1, 5);
            Course course2 = new Course("Финский язык", prof2, 3);

//  тестируем, что ошибка правильно выбрасывается в случае пустого курса:
//            Course course3 = new Course("", prof2, 5);
//            String newCourseName = null;
//            Course course4 = new Course(newCourseName, prof2, 10);

            course2.publish("Занятие перенесено на пятницу!");
            course2.publish("Добавлена новая тема по падежам.");
            course2.showFeed();

            Student s1 = new Student("Дмитрий", 2001, "ПМИ");
            Student s2 = new Student("Дарья", 2002, "Экономика");
            Student s3 = new Student("Диана", 2003, "Менеджмент");
            Student s4 = new Student("Наталья", 2004, "Менеджмент");
            Student s5 = new Student("София", 2005, "Экономика");
            Student s6 = new Student("Алексей", 2006, "Менеджмент");

            course1.addStudent(s1);
            course1.addStudent(s3);

            course2.addStudent(s2);
            course2.addStudent(s3);
            course2.addStudent(s4);
            course2.addStudent(s5);
            course2.addStudent(s6);
            course2.removeStudent(s2);
            course2.processWaitingList();

            University university = new University();
            university.addCourse(course1);
            university.addCourseToDept("Филология", course2);
            university.addCourse(course2);
            university.removeCourse(course1);

            university.registerStudent(s1);
            university.registerStudent(s2);
            university.registerStudent(s3);
            university.registerStudent(s4);
            university.registerStudent(s5);
            university.registerStudent(s6);

            try {
                university.findStudentById(2003);
                university.findStudentById(2010);
            }
            catch (StudentNotFoundException e) {
                System.out.println("Ошибка при поиске студента: " + e.getMessage());
            }


            university.showAllCourses();

        } catch (InvalidCourseException e) {
            System.out.println("Ошибка при создании курса: " + e.getMessage());
        }
    }
}