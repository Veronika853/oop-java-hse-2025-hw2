/**
 * Класс, представляющий студента университета.
 * Наследуется от {@link UniversityMember} и добавляет информацию о студенте.
 */

public class Student extends UniversityMember {
    private final String major;

    /**
     * Создаёт нового студента с указанным именем, идентификатором и специальностью.
     *
     * @param name  имя студента
     * @param id    уникальный идентификатор студента
     * @param major специальность студента
     */
    public Student(String name, int id, String major) {
        super(name, id);
        if (major == null || major.isEmpty()) {
            throw new IllegalArgumentException("Специальность не может быть null или пустой.");
        }
        this.major = major;
    }

    /**
     * Возвращает подробную информацию о студенте, включая идентификатор, имя и специальность.
     *
     * @return строка с информацией о студенте
     */
    @Override
    public String getDetails() {
        return "ID студента: " + id + ", Имя: " + name + ", специальность: " + major;
    }
}
