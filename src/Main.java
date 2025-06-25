/**
 * Главный класс приложения, демонстрирующий функциональность университетской системы.
 * Создаёт университет, кафедры, профессоров, курсы и студентов, а также выполняет операции
 * добавления, удаления и вывода информации о курсах и студентах.
 */
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Создаем университет и кафедры:");
            University university = new University();
            Department dept1 = new Department("Компьютерные науки", null);
            Department dept2 = new Department("Филология", null);
            Department dept3 = new Department("Логистика", null);
            university.addDepartment(dept1);
            university.addDepartment(dept2);
            university.addDepartment(dept3);

            System.out.println();
            System.out.println("Добавляем профессоров и их расписание:");
            Professor prof1 = new Professor("Иван Викторович к.ф.м.н.", 1001, dept1);
            Professor prof2 = new Professor("Алла Ивановна к.ф.н.", 1002, dept2);

            dept1.setHead(prof1);
            dept2.setHead(prof2);
            dept3.setHead(prof1);

            prof2.scheduleEvent("Заседание кафедры", "2025-09-02 15:00");
            prof2.scheduleEvent("Консультация по курсу", "2025-09-04 12:00");

            System.out.println();
            System.out.println("Добавляем курсы, расписание и новости:");
            Course course1 = new Course("Введение в программирование", prof1, 5);
            Course course2 = new Course("Финский язык", prof2, 3);
            Course course3 = new Course("Дискретная математика", null, 5);
            Course course4 = new Course("Линейная алгебра", null, 2);

            course3.setProfessor(prof1);

            course2.scheduleEvent("Лекция 1: История и падежи", "2025-09-01 10:00");
            course2.scheduleEvent("Практика 1: Nominatiivi, Genitiivi", "2025-09-01 11:40");
            course3.scheduleEvent("Лекция 1: Виды графов", "2025-09-02 13:20");

            course2.publish("Занятие 1 перенесено на понедельник!");
            course2.publish("Добавлена новая тема по падежам.");
            course3.publish("Добавлен конспект 1 лекции.");

            System.out.println();
            System.out.println("Добавляем студентов: ");
            Student s1 = new Student("Дмитрий", 2001, "ПМИ");
            Student s2 = new Student("Дарья", 2002, "Экономика");
            Student s3 = new Student("Диана", 2003, "Менеджмент");
            Student s4 = new Student("Наталья", 2004, "Менеджмент");
            Student s5 = new Student("София", 2005, "Экономика");
            Student s6 = new Student("Алексей", 2006, "Менеджмент");
            Student s7 = new Student("Степан", 2007, "ПМИ");
            GraduateStudent grad = new GraduateStudent("Анна", 2080, "Экономика", "Динамика акций газового российского рынка");


            course1.addStudent(s1);
            course1.addStudent(s3);
            course2.addStudent(s2);
            course2.addStudent(s3);
            course2.addStudent(s4);
            course2.addStudent(s5);
            course2.removeStudent(s2);
            course2.addStudent(s6);
            course2.addStudent(s7);
            course3.addStudent(s1);
            course3.addStudent(s2);


            System.out.println();
            System.out.println("Добавляем кафедры и курсы в университет и регистрируем в нем студентов: ");
            university.addCourse(course1);
            university.addCourse(course2);
            university.addCourse(course3);
            university.addCourse(course4);
            university.addCourseToDept(dept1, course1);
            university.addCourseToDept(dept2, course2);
            university.addCourseToDept(dept1, course3);
            university.removeCourse(course1);

            university.registerStudent(s1);
            university.registerStudent(s2);
            university.registerStudent(s3);
            university.registerStudent(s4);
            university.registerStudent(s5);
            university.registerStudent(s6);
            university.registerStudent(s7);
            university.registerStudent(grad);


            System.out.println();
            try {
                university.findStudentById(2003);
                university.findStudentById(2080);
                university.findStudentById(2010);
            } catch (StudentNotFoundException e) {
                System.out.println("Ошибка при поиске студента: " + e.getMessage());
            }

            System.out.println();
            System.out.println("Показываем всю информацию об университете: ");
            university.showAllCourses();

        } catch (InvalidCourseException e) {
            System.out.println("Ошибка при создании курса: " + e.getMessage());
        }
    }
}