package farm.dto;

import animal.model.Animal;
import employee.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FeedingDto {

	private Employee employee;
	private Animal animal;
	private FeedType type;

	public enum FeedType {
		forPuppies, forAdults, forElderly;
	}

	@Override
	public String toString() {
		StringBuilder report = new StringBuilder();
		report.append(employee.getName() + "[" + employee.getPosition() + "]" + " feed the dog named ");
		report.append(animal.getName() + " with food " + type);
		return report.toString();
	}

}
