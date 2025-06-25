/**
 * Исключение, выбрасываемое, когда курс и его список ожидания полностью заполнены,
 * и добавление нового студента невозможно.
 */
public class CourseFullException extends Exception {
    /**
     * Создаёт новое исключение с указанным сообщением об ошибке.
     *
     * @param message сообщение, описывающее причину исключения
     */
    public CourseFullException(String message) {
        super(message);
    }
}
