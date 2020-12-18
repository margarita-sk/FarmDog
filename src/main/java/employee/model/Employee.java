package employee.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The {@code Employee} class describes the employee with its fields
 * 
 * @author Margarita Skokova
 */
@Data
@NoArgsConstructor
public class Employee {

	private int id;
	private String name;
	private int hoursWorkedPerDay;
	private int maxWorkingHoursPerDay;
	private Position position;

	public enum Position {
		veterinarian, animalKeeper, dogTrainer
	}

	public void increaseWorkedHours(int hours) {
		hoursWorkedPerDay += hours;
	}

}
