package com.conflux.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.conflux.entity.Student;
import com.conflux.service.StudentService;
import com.conflux.validation.StudentValidation;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(ModelMap model, HttpSession session) {
		if (session.getAttribute("student") == null) {
			model.put("studentData", new Student());
			return "login/login";
		} else
			return "redirect:success";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(ModelMap model, @ModelAttribute("studentData") Student student, HttpSession session) {
		if (student.getUserName() != null && student.getPassword() != null && session.getAttribute("student") != null) {
			student = studentService.loginStudent(student);
			if (student != null) {
				session.setAttribute("student", student);
				return "redirect:success";
			} else {
				model.put("failed", "Login Failed");
				return "login/login";
			}
		} else {
			return "redirect:success";
		}

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		model.put("studentData", new Student());
		return "register/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveForm(ModelMap model, @ModelAttribute("studentData") @Valid Student student, BindingResult br,
			HttpSession session) {
		StudentValidation studentValidation = new StudentValidation();
		studentValidation.validate(studentValidation, br);
		if (br.hasErrors()) {
			return "register/register";
		} else {
			studentService.saveStudent(student);
			session.setAttribute("student", student);
			return "redirect:success";
		}

	}
	
	@RequestMapping(value="/success", method=RequestMethod.GET)
	public String showSuccess(ModelMap model){
		model.put("success", new Student());
		return "success";
	}
	
	@RequestMapping(value="/success", method=RequestMethod.GET)
	public String logOut(ModelMap model, HttpSession session){
		session.removeAttribute("student");
		return "redirect:login";
	}

}
