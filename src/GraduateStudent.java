/**
 * Класс, представляющий аспиранта (или магистранта) университета.
 * Наследуется от {@link Student} и добавляет информацию о теме диссертации.
 */
public class GraduateStudent extends Student {
    private final String thesisTitle;

    /**
     * Создаёт нового аспиранта с указанным именем, идентификатором, специальностью и темой диссертации.
     *
     * @param name        имя аспиранта
     * @param id          уникальный идентификатор аспиранта
     * @param major       специальность аспиранта
     * @param thesisTitle тема диссертации, не должна быть null или пустой
     * @throws IllegalArgumentException если thesisTitle null или пустая
     */
    public GraduateStudent(String name, int id, String major, String thesisTitle) {
        super(name, id, major);
        if (thesisTitle == null || thesisTitle.isEmpty()) {
            throw new IllegalArgumentException("Тема диссертации не может быть null или пустой.");
        }
        this.thesisTitle = thesisTitle;
    }

    /**
     * Возвращает тему диссертации аспиранта.
     *
     * @return тема диссертации
     */
    public String getThesisTitle() {
        return thesisTitle;
    }

    /**
     * Возвращает подробную информацию об аспиранте, включая идентификатор, имя, специальность и тему диссертации.
     *
     * @return строка с информацией об аспиранте
     */
    @Override
    public String getDetails() {
        return super.getDetails() + ", Тема диссертации: " + thesisTitle;
    }
}
