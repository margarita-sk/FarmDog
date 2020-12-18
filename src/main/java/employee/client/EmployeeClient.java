package employee.client;

import java.io.IOException;
import java.util.Collection;

import employee.model.Employee;

/**
 * The {@code EmployeeClient} interface describes the contract, according to
 * which we can receive all objects of type {@code Employee}.
 * 
 * @author Margarita Skokova
 */
public interface EmployeeClient {

	Collection<Employee> receiveAll() throws IOException;

}
