package employee.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * The {@code EmployeeException} provides all types of exceptions(honestly, the
 * only one), which can be thrown while manipulating {@code Employee} class
 * 
 * @author Margarita Skokova
 */
@NoArgsConstructor
@Getter
public class EmployeeException extends Exception {

	private String message;

	public EmployeeException(String message) {
		this.message = message;
	}

}
