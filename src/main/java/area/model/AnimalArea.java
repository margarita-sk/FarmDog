package area.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The {@code AnimalArea} class describes the animal with fields: id, cleaness
 * condition and type
 * 
 * @author Margarita Skokova
 */
@NoArgsConstructor
@Data
public class AnimalArea {

	private int id;
	private CleanessCondition condition;
	private AreaType type;

	public enum CleanessCondition {
		clean, dirty
	}

	public enum AreaType {
		animalKennel, trainingArea
	}

}
