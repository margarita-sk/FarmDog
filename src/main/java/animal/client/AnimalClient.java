package animal.client;

import java.io.IOException;
import java.util.Collection;

import animal.model.Animal;

/**
 * The {@code AnimalClient} interface describes the contract, according to which
 * we can receive all objects of type {@code Animal}.
 * 
 * @author Margarita Skokova
 */
public interface AnimalClient {

	Collection<Animal> receiveAll() throws IOException;

}
