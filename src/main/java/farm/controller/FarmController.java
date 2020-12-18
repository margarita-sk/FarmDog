package farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import farm.service.FarmService;

/**
 * Implements receiving the day report
 * 
 * @author Margarita Skokova
 */

@Component
public class FarmController {

	private FarmService service;

	@Autowired
	public FarmController(FarmService service) {
		this.service = service;
	}

	public void receiveDayReport() {

		System.out.println("The day has begun\n");

		System.out.println("Breakfast:");
		service.reportFeeding().stream().forEach(report -> {
			System.out.println(report.toString());
		});

		System.out.println("\nThe veterinarian check up:");
		service.reportCheckingUp().stream().forEach(report -> {
			System.out.println(report.toString());
		});

		System.out.println("\nDistribution of dogs:");
		service.reportActivity().stream().forEach(report -> {
			System.out.println(report.toString());
		});

		System.out.println("\nCleanning: ");
		service.reportCleaning().stream().forEach(report -> {
			System.out.println(report.toString());
		});

		System.out.println("\nDinner: ");
		service.reportFeeding().stream().forEach(report -> {
			System.out.println(report.toString());
		});

		System.out.println("\nReport on the work done:");
		service.reportOnTheWorkDone().stream().forEach(report -> System.out.println(report.toString()));
	}

}
