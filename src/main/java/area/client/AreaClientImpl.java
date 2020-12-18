package area.client;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import area.model.AnimalArea;

/**
 * Implements receiving all objects of type {@code AnimalArea} from file of json
 * format.
 * 
 * @author Margarita Skokova
 */

@Component
public class AreaClientImpl implements AreaClient {

	@Value("${areas.path}")
	private String path;

	private ObjectMapper mapper;

	public AreaClientImpl() {
		this.mapper = new ObjectMapper();
	}

	@Override
	public Collection<AnimalArea> receiveAll() throws IOException {
		ArrayList<AnimalArea> areas = mapper.readValue(new File(path),
				mapper.getTypeFactory().constructCollectionType(ArrayList.class, AnimalArea.class));
		return areas;
	}

}
