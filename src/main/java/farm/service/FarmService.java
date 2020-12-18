package farm.service;

import java.util.Collection;

import farm.dto.ActivityDto;
import farm.dto.CheckUpDto;
import farm.dto.CleaningDto;
import farm.dto.EmployeeDto;
import farm.dto.FeedingDto;

/**
 * The {@code FarmService} interface describes the contract, according to which
 * we can fill our farm with inhabitants(animals, employees, areas) and provide
 * reports of different aspects of farm life
 * 
 * @author Margarita Skokova
 */
public interface FarmService {

	void fillFarmWithInhabitants();

	Collection<FeedingDto> reportFeeding();

	Collection<CheckUpDto> reportCheckingUp();

	Collection<ActivityDto> reportActivity();

	Collection<CleaningDto> reportCleaning();

	Collection<EmployeeDto> reportOnTheWorkDone();

}
