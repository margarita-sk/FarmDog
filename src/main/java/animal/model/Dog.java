package animal.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The {@code Dog} describes the dog
 * 
 * @author Margarita Skokova
 */

@ToString(callSuper = true)
@NoArgsConstructor
@Setter
@Getter
public class Dog extends Animal {

	private Specialization specialization;
	private int levelSkill;

	public enum Specialization {
		police, rescueService, puppy, retiree
	}

}
