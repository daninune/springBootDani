package com.example.demo.controller;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.model.employee.Employee;
import com.example.demo.model.employee.EmployeeDAO;
import com.example.demo.model.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 3;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/home")
    public String getHome(){

        return "home";
    }

    @GetMapping("/employees/{pageNo}")
    public String getEmployees(Model model,@PathVariable(value="pageNo") int pageNo
                                                              ) {
        int pageSize=5;

        List<Employee> employeeList =employeeService.getEmployees();
        model.addAttribute("currentPage",pageNo);
        //model.addAttribute("totalPages",employeePage.getTotalPages());
        //model.addAttribute("totalRecords",employeePage.getTotalElements());
        model.addAttribute("employees", employeeList);


        return "employees";
    }
    @GetMapping("/employees/new")
    public String newEmployee(Model  model){
        model.addAttribute("employee",new Employee());
        return "new";
    }
    @PostMapping("/employees/save")
    public String saveEmployee(@ModelAttribute("employee") Employee emp,Model model){
        System.out.println("name "+emp.getName());
        model.addAttribute("employee",new Employee());
        employeeService.save(emp);
        return "redirect:/employees/0";
    }
    @PostMapping("/employees/edit")
    public String editEmployee(@ModelAttribute("employee") Employee emp,Model model){
         model.addAttribute("employee",new Employee());
        employeeService.save(emp);
        return "redirect:/employees/2";
    }
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
         // call delete employee method
        this.employeeService.deleteById((int) id);
        return "redirect:/employees/0";
    }
    @GetMapping("/editEmployee/{id}")
    public String editEmployee(@PathVariable(value = "id") long id,Model model) {
        System.out.println(" id "+id);
        // call delete employee method1
        Employee emp=this.employeeService.findById((int) id);

        return "editEmployee";
    }
    @GetMapping("/employeesDTO")
    public String getEmployeesDTO(Model model) {
        List<Employee> employees = employeeService.getEmployees();
        List<EmployeeDTO> employeesDTO = employeeMapper.toEmployeeDTOList(employees);
        model.addAttribute("employees", employeesDTO);
        return "employeesDTO";
    }
}
