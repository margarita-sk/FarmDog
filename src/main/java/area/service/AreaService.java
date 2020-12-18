package area.service;

import java.io.IOException;
import java.util.Collection;

import area.model.AnimalArea;

/**
 * The {@code AreaService} interface describes the contract, according to which
 * we can receive all objects of type {@code AnimalArea}.
 * 
 * @author Margarita Skokova
 */
public interface AreaService {

	Collection<AnimalArea> receiveAll() throws IOException;

}
