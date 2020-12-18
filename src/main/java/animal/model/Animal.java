package animal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The {@code Animal} abstract class describes the animal with fields: id, name,
 * age, health and hunger condition
 * 
 * @author Margarita Skokova
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Animal {

	private int id;
	private String name;
	private double age;
	private HealthCondition healthCondition;
	private HungerCondition hungerCondition;

	public enum HealthCondition {
		healthy, sick
	}

	public enum HungerCondition {
		full, hungry
	}

	@Override
	public String toString() {
		return name + " [age=" + age + "]";
	}

}
