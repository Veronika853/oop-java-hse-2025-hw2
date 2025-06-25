/**
 * Класс, представляющий члена университетской системы, такого как студент или профессор.
 * Реализует интерфейс {@link Person} для предоставления информации о человеке.
 */
public class UniversityMember implements Person {
    String name;
    int id;

    /**
     * Создаёт нового члена университета с указанным именем и идентификатором.
     *
     * @param name имя
     * @param id   уникальный идентификатор
     * @throws IllegalArgumentException если имя null или пустое
     */
    public UniversityMember(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Возвращает общую информацию о члене университета.
     * Подклассы могут переопределять этот метод для предоставления более конкретной информации.
     *
     * @return строка с информацией о персоне
     */
    @Override
    public String getDetails() {
        return "Человек из университета";
    }

    /**
     * Возвращает идентификатор члена университета.
     *
     * @return уникальный идентификатор
     */
    public Integer getId() {
        return id;
    }
}
