package employee.client;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import employee.model.Employee;

/**
 * Implements receiving all objects of type {@code Employee} from file of json
 * format.
 * 
 * @author Margarita Skokova
 */

@Component
public class EmployeeClientImpl implements EmployeeClient {

	@Value("${employees.path}")
	private String path;

	private ObjectMapper mapper;

	public EmployeeClientImpl() {
		this.mapper = new ObjectMapper();
	}

	@Override
	public Collection<Employee> receiveAll() throws IOException {
		ArrayList<Employee> employees = mapper.readValue(new File(path),
				mapper.getTypeFactory().constructCollectionType(ArrayList.class, Employee.class));
		return employees;
	}

}
