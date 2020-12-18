package area.service;

import java.io.IOException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import area.client.AreaClient;
import area.model.AnimalArea;

/**
 * Implements receiving all objects of type {@code AnimalArea}
 * 
 * @author Margarita Skokova
 */

@Component
public class AreaServiceImpl implements AreaService {

	private AreaClient client;

	@Autowired
	public AreaServiceImpl(AreaClient client) {
		this.client = client;
	}

	public Collection<AnimalArea> receiveAll() throws IOException {
		return client.receiveAll();
	}

}
