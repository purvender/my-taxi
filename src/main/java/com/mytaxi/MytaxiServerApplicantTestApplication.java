package com.mytaxi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mytaxi.dataaccessobject.CarRepository;
import com.mytaxi.dataaccessobject.DriverRepository;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainvalue.OnlineStatus;
import com.mytaxi.util.LoggingInterceptor;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableCaching
public class MytaxiServerApplicantTestApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(MytaxiServerApplicantTestApplication.class, args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoggingInterceptor()).addPathPatterns("/**");
	}

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(getClass().getPackage().getName())).paths(PathSelectors.any())
				.build().apiInfo(generateApiInfo());
	}

	private ApiInfo generateApiInfo() {
		return new ApiInfo("mytaxi Server Applicant Test Service",
				"This service is to check the technology knowledge of a server applicant for mytaxi.",
				"Version 1.0 - mw", "urn:tos", "career@metalbook.com", "Apache 2.0",
				"http://www.apache.org/licenses/LICENSE-2.0");
	}

	@Bean
	CommandLineRunner commandLineRunner(CarRepository carRepositoryMongo,
			DriverRepository driverRepositoryMongo) {
		return strings -> {
			carRepositoryMongo
					.save(new CarDO("XYAB0087", 0, 5, 5, "petrol", "black", "Sedan", "Audi", "A7", "manual"));
			carRepositoryMongo
					.save(new CarDO("XYAB0088", 4, 0, 5, "petrol", "black", "Sedan", "Audi2", "A7", "auto"));

			driverRepositoryMongo.save(new DriverDO("driver04pw", "driver04",false, OnlineStatus.OFFLINE, "auto"));
			driverRepositoryMongo.save(new DriverDO("driver01", "driver01pw",false, OnlineStatus.ONLINE, "auto"));

			driverRepositoryMongo.save(new DriverDO("driver02", "driver02pw",true, OnlineStatus.ONLINE, "manual"));

		};
	}

}
