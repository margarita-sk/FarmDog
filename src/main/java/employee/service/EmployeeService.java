package employee.service;

import java.io.IOException;
import java.util.Collection;

import employee.model.Employee;
import employee.model.Employee.Position;
import farm.model.Farm;

/**
 * The {@code EmployeeClient} interface describes the contract, according to
 * which we can receive all objects of type {@code Employee} and receive an
 * employee from the farm by its position(it means profession)
 * 
 * @author Margarita Skokova
 */
public interface EmployeeService {

	Collection<Employee> receiveAll() throws IOException;

	Employee recieveByPosition(Farm farm, Position position);

}
