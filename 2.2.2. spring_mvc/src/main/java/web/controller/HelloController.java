package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import serice.CarServiceImp;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}
	@GetMapping(value = "/cars")
	public String printCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model){
		CarServiceImp carServiceImp = new CarServiceImp();
		if(count == null || count >= 5){
			model.addAttribute("cars", carServiceImp.getCars());
		}
		else{
			model.addAttribute("cars", carServiceImp.getCars().subList(0, count));
		}
		return "car";
	}
}