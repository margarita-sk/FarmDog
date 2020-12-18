package farm.dto;

import animal.model.Animal;
import employee.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CheckUpDto {

	private Employee employee;
	private Animal animal;
	private String employeeAction;

	@Override
	public String toString() {
		StringBuilder report = new StringBuilder();
		report.append(employee.getName() + "[" + employee.getPosition() + "]" + " examined the dog ");
		report.append(animal.getName() + ". It was " + animal.getHealthCondition());
		report.append(", thus, the vet " + employeeAction + " the dog");
		return report.toString();
	}

}
