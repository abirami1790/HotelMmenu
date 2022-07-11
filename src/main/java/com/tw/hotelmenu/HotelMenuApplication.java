package com.tw.hotelmenu;


import com.tw.hotelmenu.model.Menu;
import com.tw.hotelmenu.repository.MenuRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HotelMenuApplication {
	public static void main(String[] args) {
		try{
			SpringApplication.run(HotelMenuApplication.class, args);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}
	/*@Bean
	public CommandLineRunner setup(MenuRepository menuRepository) {
		return (args) -> {
			menuRepository.save(new Menu("Chicken Biriyani", 250));
			menuRepository.save(new Menu("chicken 65", 110));
			menuRepository.save(new Menu("Mutton chukka", 120));
			menuRepository.save(new Menu("grill chicken", 130));
		};
	}*/

}
