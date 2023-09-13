package skypro.employeeBook.gohl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Сотрудник с таким именем и фамилией уже существует в фирме.")
public class EmployeeAlreadyAddedException extends RuntimeException {
}
