package farm.dto;

import area.model.AnimalArea;
import employee.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CleaningDto {
	private Employee employee;
	private AnimalArea area;

	@Override
	public String toString() {
		return employee.getName() + "[" + employee.getPosition() + "]" + " cleaned " + area.getType();
	}
}
