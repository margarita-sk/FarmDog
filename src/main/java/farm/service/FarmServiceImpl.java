package farm.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import animal.model.Animal;
import animal.model.Animal.HealthCondition;
import animal.model.Animal.HungerCondition;
import animal.model.Dog;

import animal.service.AnimalService;
import area.model.AnimalArea.CleanessCondition;
import area.service.AreaService;
import employee.model.Employee;
import employee.model.Employee.Position;
import employee.service.EmployeeService;
import farm.dto.ActivityDto;
import farm.dto.ActivityDto.ActivityType;
import farm.dto.CheckUpDto;
import farm.dto.CleaningDto;
import farm.dto.EmployeeDto;
import farm.dto.FeedingDto;
import farm.dto.FeedingDto.FeedType;
import farm.model.Farm;
import lombok.Data;
import lombok.extern.log4j.Log4j;

/**
 * The {@code FarmServiceImpl} implements the contract methods
 * 
 * @author Margarita Skokova
 */

@Data
@Log4j
@Component
public class FarmServiceImpl implements FarmService {

	private EmployeeService employeeService;
	private AnimalService animalService;
	private AreaService areaService;

	private Farm farm;

	@Autowired
	public FarmServiceImpl(EmployeeService employeeService, AnimalService animalService, AreaService areaService) {
		this.employeeService = employeeService;
		this.animalService = animalService;
		this.areaService = areaService;
		fillFarmWithInhabitants();
	}

	@Override
	public void fillFarmWithInhabitants() {
		try {
			farm = new Farm(employeeService.receiveAll(), animalService.recieveAll(), areaService.receiveAll());
		} catch (IOException e) {
			System.out.println(e.getMessage());
			log.error(e);
		}
	}

	@Override
	public Collection<FeedingDto> reportFeeding() {
		Collection<FeedingDto> report = new ArrayList<>();
		farm.getAnimals().stream().forEach(animal -> {
			Employee employee = employeeService.recieveByPosition(farm, Position.animalKeeper);
			animal.setHungerCondition(HungerCondition.full);
			employee.setHoursWorkedPerDay(employee.getHoursWorkedPerDay() + 1);
			report.add(new FeedingDto(employee, animal, choseFeedType(animal)));
		});
		return report;
	}

	@Override
	public Collection<CheckUpDto> reportCheckingUp() {
		Collection<CheckUpDto> report = new ArrayList<>();
		farm.getAnimals().forEach(animal -> {
			Employee employee = employeeService.recieveByPosition(farm, Position.veterinarian);
			report.add(new CheckUpDto(employee, animal, choseVetAction(animal)));
			animal.setHealthCondition(HealthCondition.healthy);
		});
		return report;
	}

	@Override
	public Collection<ActivityDto> reportActivity() {
		Collection<ActivityDto> report = new ArrayList<>();
		farm.getAnimals().forEach(animal -> {
			var activityType = chooseAnimalActivity(animal);
			Employee employee = employeeService.recieveByPosition(farm, chooseRequiredTypeOfWorker(activityType));
			report.add(new ActivityDto(employee, (Dog) animal, activityType));
		});
		return report;
	}

	@Override
	public Collection<CleaningDto> reportCleaning() {
		Collection<CleaningDto> report = new ArrayList<>();
		farm.getAreas().stream().forEach(area -> {
			var employee = employeeService.recieveByPosition(farm, Position.animalKeeper);
			area.setCondition(CleanessCondition.clean);
			report.add(new CleaningDto(employee, area));
		});
		return report;
	}

	@Override
	public Collection<EmployeeDto> reportOnTheWorkDone() {
		Collection<EmployeeDto> report = new ArrayList<>();
		farm.getEmployees().stream().forEach(employee -> {
			report.add(new EmployeeDto(employee));
		});
		return report;
	}

	/*
	 * small helper methods
	 */
	private FeedType choseFeedType(Animal animal) {
		var type = FeedType.forAdults;
		if (animal.getAge() < 1) {
			type = FeedType.forPuppies;
		} else if (animal.getAge() >= 8) {
			type = FeedType.forElderly;
		}
		return type;
	}

	private String choseVetAction(Animal animal) {
		String action = "petted";
		if (HealthCondition.sick.equals(animal.getHealthCondition())) {
			action = "healed";
		}
		return action;
	}

	private Position chooseRequiredTypeOfWorker(ActivityType type) {
		if (ActivityType.train.equals(type)) {
			return Position.dogTrainer;
		}
		return Position.animalKeeper;
	}

	private ActivityType chooseAnimalActivity(Animal animal) {
		var type = ActivityType.work;
		if (animal.getAge() < 1) {
			type = ActivityType.train;
			((Dog) animal).setLevelSkill(((Dog) animal).getLevelSkill() + 1);
		} else if (animal.getAge() >= 8) {
			type = ActivityType.rest;
		}
		animal.setHungerCondition(HungerCondition.hungry);
		return type;
	}

}
