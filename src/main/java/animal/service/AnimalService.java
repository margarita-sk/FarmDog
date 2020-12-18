package animal.service;

import java.io.IOException;
import java.util.Collection;

import animal.model.Animal;

/**
 * The {@code AnimalService} interface describes the contract, according to
 * which we can receive all objects of type {@code Animal}.
 * 
 * @author Margarita Skokova
 */
public interface AnimalService {

	Collection<Animal> recieveAll() throws IOException;

}
