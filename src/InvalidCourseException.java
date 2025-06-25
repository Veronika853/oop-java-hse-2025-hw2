/**
 * Исключение, выбрасываемое, когда создаётся курс с недопустимыми параметрами,
 * например, с пустым или null названием.
 */
public class InvalidCourseException extends Exception {

    /**
     * Создаёт новое исключение с указанным сообщением об ошибке.
     *
     * @param message сообщение, описывающее причину исключения
     */
    public InvalidCourseException(String message) {
        super(message);
    }
}
