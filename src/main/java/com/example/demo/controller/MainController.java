package com.example.demo.controller;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.model.customer.Customer;
import com.example.demo.model.customer.CustomerService;
import com.example.demo.model.employee.Employee;
import com.example.demo.model.employee.EmployeeDAO;
import com.example.demo.model.employee.EmployeeService;
import com.example.demo.model.paises.PaisRepository;
import com.example.demo.model.paises.Paises;
import com.example.demo.model.provinces.ProvinceService;
import com.example.demo.model.provinces.Provinces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class MainController {
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 3;


    private final int ROW_PER_PAGE = 5;

    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    ProvinceService provinceService;

    @Autowired
    CustomerService customerService;
    @Autowired
    PaisRepository paisService;

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/home")
    public String getHome(){

        return "home";
    }
    /*
    *
    *  @GetMapping("/")
    public String createIndex(Model model, @RequestParam(defaultValue = "0", name = "page") int page) {
        model.addAttribute("siswas", siswaDao.findAll(new PageRequest(page, 4)));
        model.addAttribute("buatPage", page);
        model.addAttribute("buatSiswa", new Siswa());
        return "index";
    }
    *
    *
    *
    * */

    @GetMapping("/employees")
    public String getEmployees(
            Model model,
            @RequestParam(value = "page") Optional<Integer> page,
            @RequestParam(value = "size") Optional<Integer> size)
    {
        int currentPage=page.orElse(1);
        int pageSize=size.orElse(5);
        Page<Employee> employeesPage=
                this.employeeService.findAllEmployees(PageRequest.of(currentPage-1,pageSize));
           model.addAttribute("employeePage",employeesPage);
           int totalPages=employeesPage.getTotalPages();
          if (totalPages>0){
              List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages)
                      .boxed().collect(Collectors.toList());
              model.addAttribute("pageNumbers",pageNumbers);

          }

        return "employees";
    }
    @GetMapping("/employees/new")
    public String newEmployee(Model  model){
        model.addAttribute("employee",new Employee());
        List<Provinces> provincesList=provinceService.getProvinces();
        List<Customer> customers=customerService.getCustomers();
        List<Paises> paises=paisService.getPaises();
        model.addAttribute("paises",paises);
        model.addAttribute("provinces",provincesList);
        model.addAttribute("customers",customers);
        return "new";
    }
    @PostMapping("/employees/save")
    public String saveEmployee(@ModelAttribute("employee") Employee emp,Model model){

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
        model.addAttribute("employee",emp);
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
