import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

import static java.lang.Math.round;

public class Course implements Publishable, Schedulable {
    private String courseName;
    private Professor professor;
    private ArrayList<Student> students;
    private Queue<Student> waitingList;
    private LinkedList<String> feed;
    private int maxStudents;
    private int maxWaitingListSize;
    private LinkedList<Event> schedule = new LinkedList<>();

    public Course(String courseName, Professor professor, int maxStudents) throws InvalidCourseException {
        if (courseName == null || courseName.isEmpty()) {
            throw new InvalidCourseException("Курс обязательно должен иметь название");
        }
        this.courseName = courseName;
        this.professor = professor;
        this.students = new ArrayList<>();
        this.waitingList = new LinkedList<>();
        this.feed = new LinkedList<>();
        this.maxStudents = maxStudents;
        this.maxWaitingListSize = round(maxStudents / 3);
    }

    public void addStudent(Student student) throws CourseFullException {
        if (students.size() < maxStudents) {
            students.add(student);
            System.out.println(student.getDetails() + " зачислен(а) на курс \"" + courseName + "\".");
        } else if (waitingList.size() < maxWaitingListSize) {
            waitingList.add(student);
            System.out.println(student.getDetails() + " зачислен(а) в список ожидания курса \"" + courseName + "\".");
        } else {
            throw new CourseFullException("На курсе \"" + courseName + "\" не осталось мест");
        }
    }



    public void processWaitingList() {
        while (!waitingList.isEmpty() && students.size() < maxStudents) {
            Student nextStudent = waitingList.poll();
            students.add(nextStudent);
            System.out.println(nextStudent.getDetails() + " переведён(а) из списка ожидания на курс \"" + courseName + "\".");
        }
    }

    public int getWaitingListSize() {
        return waitingList.size();
    }

    public void removeStudent(Student student) {
        students.remove(student);
        System.out.println(student.getDetails() + " удален(а) с курса \"" + courseName + "\".");
    }

    public int getNumberOfStudents() {
        return students.size();
    }

    public String getCourseName() {
        return courseName;
    }

    public void showCourseDetails() {
        System.out.println("Курс: " + courseName);
        System.out.println("Преподаватель: " + professor.getDetails());
        System.out.println("Количество студентов на курсе: " + getNumberOfStudents());
        System.out.println("Максимальное количество студентов на курсе: " + maxStudents);
        System.out.println("Количество студентов в очереди: " + getWaitingListSize());
        System.out.println("Записанные студенты:");
        for (Student student: students) {
            System.out.println(" - " + student.getDetails());
        }
        System.out.println("Расписание курса:");
        if (schedule.isEmpty()) {
            System.out.println(" - Расписание пока не назначено.");
        } else {
            for (Event e : schedule) {
                System.out.println(" - " + e.getDateTime() + ": " + e.getDescription());
            }
        }
        showFeed();
    }

    @Override
    public void publish(String message) {
        feed.addLast(message);
        System.out.println("Новое объявление: " + message);
    }

    @Override
    public List<String> getFeed() {
        return feed;
    }

    @Override
    public void scheduleEvent(String description, String dateTime) {
        schedule.add(new Event(description, dateTime));
    }

    @Override
    public List<Event> getSchedule() {
        return schedule;
    }

    public void showFeed() {
        List<String> announcements = getFeed();
        if (announcements.isEmpty()) {
            System.out.println("Для курса \"" + courseName + "\" пока нет объявлений.");
        } else {
            System.out.println("Все объявления курса \"" + courseName + "\":");
            for (String announcement : announcements) {
                System.out.println(" - " + announcement);
            }
        }
    }
}
