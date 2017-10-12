package com.lukaszowaty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lukaszowaty.model.Instructor;
import com.lukaszowaty.service.InstructorService;

@Controller
@RequestMapping("/instructor")
public class InstructorController {
	
	// need to inject the instructor service
	@Autowired
	private InstructorService instructorService;
	

	@GetMapping("/list")
	public String listInstructors(Model model) {
		
		// get instructors from the service
		List<Instructor> instructors = instructorService.getInstructors();
		
		// add the instructors to the model
		model.addAttribute("instructors", instructors);
		
		return "list-instructors";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model){
		
		// create model attribute to bind form data
		Instructor instructor = new Instructor();
		
		model.addAttribute("instructor", instructor);
		
		return "instructor-form";
	}
	
	@PostMapping("/saveInstructor")
	public String saveInstructor(@ModelAttribute("instructor") Instructor instructor) {
		
		// save the customer using our service
		instructorService.saveInstructor(instructor);
		
		
		return "redirect:/instructor/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("instructorId") int id, Model model) {
		
		// get the instructor from our service
		Instructor instructor = instructorService.getInstructor(id);
		// set instructor as a model attribute
		model.addAttribute("instructor", instructor);
		// send over to form
		return "instructor-form";
	}
	
	@GetMapping("/delete")
	public String deleteInstructor(@RequestParam("instructorId") int id) {
		
		// delete the instructor
		instructorService.deleteInstructor(id);
		
		return "redirect:/instructor/list";
	}
	
}
