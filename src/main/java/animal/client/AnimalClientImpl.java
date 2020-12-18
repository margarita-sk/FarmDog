package animal.client;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import animal.model.Animal;
import animal.model.Dog;

/**
 * Implements receiving all objects of type {@code Animal} from file of json
 * format.
 * 
 * @author Margarita Skokova
 */

@Component
public class AnimalClientImpl implements AnimalClient {

	@Value("${animals.path}")
	private String path;

	private ObjectMapper mapper;

	public AnimalClientImpl() {
		this.mapper = new ObjectMapper();
	}

	public Collection<Animal> receiveAll() throws IOException {
		ArrayList<Animal> animals = mapper.readValue(new File(path),
				mapper.getTypeFactory().constructCollectionType(ArrayList.class, Dog.class));
		return animals;
	}

}
