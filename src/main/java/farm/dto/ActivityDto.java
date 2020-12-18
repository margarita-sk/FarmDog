package farm.dto;

import animal.model.Dog;
import employee.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ActivityDto {

	private Employee employee;
	private Dog dog;
	private ActivityType type;

	public enum ActivityType {
		train, work, rest
	}

	@Override
	public String toString() {
		StringBuilder report = new StringBuilder();
		report.append(employee.getName() + "[" + employee.getPosition() + "]" + " sent the dog ");
		report.append(dog.getName() + " [age: " + dog.getAge() + "]" + " to ");
		if (ActivityType.work.equals(type)) {
			report.append(dog.getSpecialization() + " ");
		}
		report.append(type);
		return report.toString();
	}

}
