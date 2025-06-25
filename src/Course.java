import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Класс, представляющий учебный курс в университете.
 * Реализует интерфейсы {@link Publishable} для публикации объявлений и {@link Schedulable} для управления расписанием.
 */
public class Course implements Publishable, Schedulable {
    private final String courseName;
    private Professor professor;
    private final ArrayList<Student> students;
    private final Queue<Student> waitingList;
    private final LinkedList<String> feed;
    private final int maxStudents;
    private final int maxWaitingListSize;
    private final LinkedList<Event> schedule = new LinkedList<>();

    /**
     * Создаёт новый курс с указанным названием и максимальным количеством студентов.
     * Профессор может быть не указан (null) и назначен позже.
     *
     * @param courseName  название курса
     * @param professor   преподаватель курса, может быть null
     * @param maxStudents максимальное количество студентов
     * @throws InvalidCourseException если название курса пустое или null
     */
    public Course(String courseName, Professor professor, int maxStudents) throws InvalidCourseException {
        if (courseName == null || courseName.isEmpty()) {
            throw new InvalidCourseException("Курс обязательно должен иметь название");
        }
        if (maxStudents <= 0) {
            throw new InvalidCourseException("Максимальное количество студентов должно быть больше 0");
        }
        this.courseName = courseName;
        this.professor = professor;
        this.students = new ArrayList<>();
        this.waitingList = new LinkedList<>();
        this.feed = new LinkedList<>();
        this.maxStudents = maxStudents;
        this.maxWaitingListSize = Math.round(maxStudents / 3.0f);
    }

    /**
     * Создаёт новый курс без профессора с указанным названием и максимальным количеством студентов.
     *
     * @param courseName  название курса
     * @param maxStudents максимальное количество студентов
     * @throws InvalidCourseException если название курса пустое или null
     */
    public Course(String courseName, int maxStudents) throws InvalidCourseException {
        this(courseName, null, maxStudents);
    }

    /**
     * Возвращает профессора, назначенного на курс.
     *
     * @return преподаватель курса или null, если профессор не назначен
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * Назначает профессора для курса.
     *
     * @param professor преподаватель курса, может быть null
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
        System.out.println("Профессор " + (professor != null ? professor.getDetails() : "не назначен") + " установлен для курса \"" + courseName + "\".");
    }

    /**
     * Добавляет студента на курс или в список ожидания.
     * Если курс и список ожидания полны, выводит сообщение об ошибке.
     *
     * @param student студент для добавления
     */
    public void addStudent(Student student) {
        if (student == null) {
            System.out.println("Ошибка: Студент не может быть null.");
            return;
        }
        try {
            if (students.size() < maxStudents) {
                students.add(student);
                System.out.println(student.getDetails() + " зачислен(а) на курс \"" + courseName + "\".");
            } else if (waitingList.size() < maxWaitingListSize) {
                waitingList.add(student);
                System.out.println(student.getDetails() + " зачислен(а) в список ожидания курса \"" + courseName + "\".");
            } else {
                throw new CourseFullException("На курсе \"" + courseName + "\" не осталось мест для студента " + student.getDetails() + ".");
            }
            processWaitingList();
        } catch (CourseFullException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    /**
     * Удаляет студента из курса или списка ожидания.
     *
     * @param student студент для удаления
     */
    public void removeStudent(Student student) {
        boolean removed = students.remove(student) || waitingList.remove(student);
        if (removed) {
            System.out.println(student.getDetails() + " удален(а) из курса \"" + courseName + "\".");
        } else {
            System.out.println("Студент " + student.getDetails() + " не найден на курсе \"" + courseName + "\".");
        }
        processWaitingList();
    }

    /**
     * Переносит студентов из списка ожидания на курс, если есть свободные места.
     */
    private void processWaitingList() {
        while (!waitingList.isEmpty() && students.size() < maxStudents) {
            Student nextStudent = waitingList.poll();
            students.add(nextStudent);
            System.out.println(nextStudent.getDetails() + " переведён(а) из списка ожидания на курс \"" + courseName + "\".");
        }
    }

    /**
     * Публикует новое объявление для курса, добавляя его в ленту новостей.
     * Выводит сообщение о новом объявлении в консоль.
     *
     * @param message текст объявления
     */
    @Override
    public void publish(String message) {
        if (message == null || message.isEmpty()) {
            System.out.println("Ошибка: Объявление не может быть пустым.");
            return;
        }
        feed.addLast(message);
        System.out.println("Новое объявление на курсе " + courseName + ": " + message);
    }

    /**
     * Возвращает список всех объявлений курса.
     *
     * @return список строк с объявлениями
     */
    @Override
    public List<String> getFeed() {
        return feed;
    }

    /**
     * Планирует новое событие для курса, добавляя его в расписание.
     * Выводит сообщение о запланированном событии в консоль.
     *
     * @param description описание события
     * @param dateTime    дата и время события в формате строки
     */
    @Override
    public void scheduleEvent(String description, String dateTime) {
        if (description == null || dateTime == null) {
            System.out.println("Ошибка: Описание или дата события не могут быть null.");
            return;
        }
        schedule.add(new Event(description, dateTime));
        System.out.println("На курсе " + courseName + " запланировано событие: \"" + description + "\" на " + dateTime);
    }

    /**
     * Возвращает список всех запланированных событий курса.
     *
     * @return список событий
     */
    @Override
    public List<Event> getSchedule() {
        return schedule;
    }

    /**
     * Выводит подробную информацию о курсе, включая студентов, расписание и объявления.
     */
    public void showCourseDetails() {
        System.out.println("Курс: " + courseName);
        System.out.println("Преподаватель: " + (professor != null ? professor.getDetails() : "не назначен"));
        System.out.println("Количество студентов на курсе: " + getNumberOfStudents());
        System.out.println("Максимальное количество студентов на курсе: " + maxStudents);
        System.out.println("Количество студентов в очереди: " + getWaitingListSize());
        System.out.println("Записанные студенты:");
        if (students.isEmpty()) {
            System.out.println("Нет студентов.");
        } else {
            for (Student student : students) {
                System.out.println(" - " + student.getDetails());
            }
        }
        System.out.println("Расписание курса:");
        if (schedule.isEmpty()) {
            System.out.println("Расписание отсутствует.");
        } else {
            for (Event e : schedule) {
                System.out.println(" - " + e.getDescription() + " (" + e.getDateTime() + ")");
            }
        }
    }

    /**
     * Возвращает текущее количество студентов на курсе.
     *
     * @return количество студентов
     */
    public int getNumberOfStudents() {
        return students.size();
    }

    /**
     * Возвращает размер списка ожидания.
     *
     * @return размер списка ожидания
     */
    public int getWaitingListSize() {
        return waitingList.size();
    }

    /**
     * Возвращает название курса.
     *
     * @return название курса
     */
    public String getCourseName() {
        return courseName;
    }
}