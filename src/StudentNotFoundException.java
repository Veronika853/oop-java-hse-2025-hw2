/**
 * Исключение, выбрасываемое, когда студент с указанным идентификатором не найден
 * в университетской системе.
 */
public class StudentNotFoundException extends Exception {
    /**
     * Создаёт новое исключение с указанным сообщением об ошибке.
     *
     * @param message сообщение, описывающее причину исключения
     */
    public StudentNotFoundException(String message) {
        super(message);
    }
}