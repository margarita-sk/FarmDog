package employee.service;

import java.io.IOException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import employee.client.EmployeeClient;
import employee.exception.EmployeeException;
import employee.model.Employee;
import employee.model.Employee.Position;
import farm.model.Farm;
import lombok.extern.log4j.Log4j;

/**
 * The {@code EmployeeClientImpl} implements receiving all objects of type
 * {@code Employee} and receiving an employee from the farm by its position
 * 
 * @author Margarita Skokova
 */

@Log4j
@Component
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeClient client;

	@Autowired
	public EmployeeServiceImpl(EmployeeClient client) {
		this.client = client;
	}

	@Override
	public Collection<Employee> receiveAll() throws IOException {
		return client.receiveAll();
	}

	/**
	 * This method receives the employee of the searched position from the farm. If
	 * there is no suitable employee, any employee is forced to do this job because
	 * the work must be done
	 */
	@Override
	public Employee recieveByPosition(Farm farm, Position position) {
		Employee employee;
		try {
			employee = farm.getEmployees().stream()
					.filter(worker -> worker.getHoursWorkedPerDay() < worker.getMaxWorkingHoursPerDay()
							&& worker.getPosition().equals(position))
					.findFirst().orElseThrow(
							() -> new EmployeeException("There are no free " + position + " workers on the farm."));
		} catch (EmployeeException e) {
			employee = farm.getEmployees().stream().findAny().get();
			System.out.print(e.getMessage());
			System.out.println(" So, you make " + employee.getName() + " overwork ");
			log.error(e);
		}
		employee.increaseWorkedHours(1);
		return employee;
	}

}
