package animal.service;

import java.io.IOException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import animal.client.AnimalClient;
import animal.model.Animal;

/**
 * Implements receiving all objects of type {@code Animal}.
 * 
 * @author Margarita Skokova
 */

@Component
public class AnimalServiceImpl implements AnimalService {

	private AnimalClient client;

	@Autowired
	public AnimalServiceImpl(AnimalClient client) {
		this.client = client;
	}

	@Override
	public Collection<Animal> recieveAll() throws IOException {
		return client.receiveAll();
	}

}
