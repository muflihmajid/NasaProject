package com.CleanArc.ProjectNasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.CleanArc.ProjectNasa","com.CleanArc.ProjectNasa.Infrastructure.Interface.Api.Api"})
public class ProjectNasaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectNasaApplication.class, args);
	}

}
