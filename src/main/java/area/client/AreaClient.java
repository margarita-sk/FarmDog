package area.client;

import java.io.IOException;
import java.util.Collection;

import area.model.AnimalArea;

/**
 * The {@code AreaClient} interface describes the contract, according to which
 * we can receive all objects of type {@code AnimalArea}.
 * 
 * @author Margarita Skokova
 */
public interface AreaClient {

	Collection<AnimalArea> receiveAll() throws IOException;

}
