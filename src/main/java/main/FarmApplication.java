package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import farm.controller.FarmController;

public class FarmApplication {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		FarmController controller = context.getBean(FarmController.class);

		controller.receiveDayReport();

		context.close();
	}

}
