package com.example.phone_book.controller;

import com.example.phone_book.model.Employee;
import com.example.phone_book.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Employee> listEmployees = employeeService.listAll();
        model.addAttribute("listEmployees", listEmployees);
        return "index";
    }

    @RequestMapping("/new")
    public String newEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editEmployeeForm(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("edit_employee");
        Employee employee = employeeService.get(id);
        mav.addObject("employee", employee);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") long id) {
        employeeService.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<Employee> result = employeeService.search(keyword);
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("result", result);
        System.out.println(result.toString());
        return mav;
    }

}
