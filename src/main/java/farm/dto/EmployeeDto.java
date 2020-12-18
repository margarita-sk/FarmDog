package farm.dto;

import employee.model.Employee;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmployeeDto {

	private Employee employee;

	@Override
	public String toString() {
		return employee.getName() + "[" + employee.getPosition() + "]. Working hours: "
				+ employee.getHoursWorkedPerDay();
	}

}
