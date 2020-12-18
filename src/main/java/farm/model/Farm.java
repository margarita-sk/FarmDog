package farm.model;

import java.util.Collection;

import animal.model.Animal;
import area.model.AnimalArea;
import employee.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The {@code Farm} class describes the farm, which consists of employees,
 * animals, areas
 * 
 * @author Margarita Skokova
 */
@Data
@AllArgsConstructor
public class Farm {

	private Collection<Employee> employees;
	private Collection<Animal> animals;
	private Collection<AnimalArea> areas;

}
