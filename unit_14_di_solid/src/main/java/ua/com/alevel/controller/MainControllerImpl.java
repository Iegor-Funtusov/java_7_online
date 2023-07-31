package ua.com.alevel.controller;

import ua.com.alevel.annotations.BeanClass;
import ua.com.alevel.annotations.InjectBean;
import ua.com.alevel.entity.Department;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.service.DepartmentService;
import ua.com.alevel.service.EmployeeService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@BeanClass
public class MainControllerImpl implements MainController {

    @InjectBean
    private DepartmentService departmentService;
    @InjectBean
    private EmployeeService employeeService;

    @Override
    public void start() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Welcome to first crud application!");
            System.out.println("Please, select your options:");
            String select;
            menu();
            while ((select = bufferedReader.readLine()) != null) {
                crud(bufferedReader, select);
            }
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("If you want create department, please enter 1");
        System.out.println("If you want update department, please enter 2");
        System.out.println("If you want delete department, please enter 3");
        System.out.println("If you want find department, please enter 4");
        System.out.println("If you want find all departments, please enter 5");
        System.out.println("If you want create employee, please enter 6");
        System.out.println("If you want update employee, please enter 7");
        System.out.println("If you want delete employee, please enter 8");
        System.out.println("If you want find employee, please enter 9");
        System.out.println("If you want find all employees, please enter 10");
        System.out.println("If you want find all employees by departments, please enter 11");
        System.out.println("If you want find all employees by departments, please enter 12");
        System.out.println("If you want close application, please enter 13");
    }

    private void crud(BufferedReader bufferedReader, String select) throws IOException {
        switch (select) {
            case "1" -> createDepartment(bufferedReader);
            case "2" -> updateDepartment(bufferedReader);
            case "3" -> deleteDepartment(bufferedReader);
            case "4" -> findOneDepartment(bufferedReader);
            case "5" -> findAllDepartments(bufferedReader);
            case "6" -> createEmployee(bufferedReader);
            case "7" -> updateEmployee(bufferedReader);
            case "8" -> deleteEmployee(bufferedReader);
            case "9" -> findOneEmployee(bufferedReader);
            case "10" -> findAllEmployees(bufferedReader);
            case "11" -> findAllEmployeesByDepartment(bufferedReader);
            case "12" -> findAllEmployeesByExcludeDepartment(bufferedReader);
            case "13" -> System.exit(0);
        }
        menu();
    }

    private void createDepartment(BufferedReader bufferedReader) throws IOException {
        System.out.println("MainController.createDepartment");
        System.out.println("Please enter a department name");
        String name = bufferedReader.readLine();
        Department department = new Department();
        department.setName(name);
        departmentService.create(department);
    }

    private void updateDepartment(BufferedReader bufferedReader) throws IOException {
        System.out.println("MainController.updateDepartment");
        System.out.println("Please enter a department id");
        Long id = Long.parseLong(bufferedReader.readLine());
        Department department = departmentService.findById(id);
        System.out.println("Please enter a department name");
        String name = bufferedReader.readLine();
        department.setName(name);
        departmentService.update(department);
    }

    private void deleteDepartment(BufferedReader bufferedReader) throws IOException {
        System.out.println("MainController.deleteDepartment");
        System.out.println("Please enter a department id");
        Long id = Long.parseLong(bufferedReader.readLine());
        departmentService.delete(id);
    }

    private void findOneDepartment(BufferedReader bufferedReader) throws IOException {
        System.out.println("MainController.findOneDepartment");
        System.out.println("Please enter a department id");
        Long id = Long.parseLong(bufferedReader.readLine());
        Department department = departmentService.findById(id);
        System.out.println("department = " + department);
    }

    private void findAllDepartments(BufferedReader bufferedReader) {
        List<Department> departments = departmentService.findAll();
        for (Department department : departments) {
            System.out.println("department = " + department);
        }
    }

    private void createEmployee(BufferedReader bufferedReader) throws IOException {
        System.out.println("MainController.createEmployee");
        System.out.println("Please enter an employee first name");
        String firstName = bufferedReader.readLine();
        System.out.println("Please enter an employee last name");
        String lastName = bufferedReader.readLine();
        System.out.println("Please enter an employee age");
        Integer age = Integer.parseInt(bufferedReader.readLine());
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAge(age);
        employeeService.create(employee);
    }

    private void updateEmployee(BufferedReader bufferedReader) throws IOException {
        System.out.println("MainController.updateEmployee");
        System.out.println("Please enter an employee id");
        Long id = Long.parseLong(bufferedReader.readLine());
        Employee employee = employeeService.findById(id);
        System.out.println("Please enter an employee first name");
        String firstName = bufferedReader.readLine();
        System.out.println("Please enter an employee last name");
        String lastName = bufferedReader.readLine();
        System.out.println("Please enter an employee age");
        Integer age = Integer.parseInt(bufferedReader.readLine());
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAge(age);
        employeeService.update(employee);
    }

    private void deleteEmployee(BufferedReader bufferedReader) throws IOException {
        System.out.println("MainController.deleteEmployee");
        System.out.println("Please enter an employee id");
        Long id = Long.parseLong(bufferedReader.readLine());
        employeeService.delete(id);
    }

    private void findOneEmployee(BufferedReader bufferedReader) throws IOException {
        System.out.println("MainController.findOneEmployee");
        System.out.println("Please enter an employee id");
        Long id = Long.parseLong(bufferedReader.readLine());
        Employee employee = employeeService.findById(id);
        System.out.println("employee = " + employee);
    }

    private void findAllEmployees(BufferedReader bufferedReader) {
        System.out.println("MainController.findAllEmployees");
        List<Employee> employees = employeeService.findAll();
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
    }

    private void findAllEmployeesByDepartment(BufferedReader bufferedReader) throws IOException {
        System.out.println("MainController.findAllEmployeesByDepartment");
        System.out.println("Please enter a department id");
        Long id = Long.parseLong(bufferedReader.readLine());
        List<Employee> employees = employeeService.findAllEmployeesByDepartment(id);
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
    }

    private void findAllEmployeesByExcludeDepartment(BufferedReader bufferedReader) throws IOException {
        System.out.println("MainController.findAllEmployeesByExcludeDepartment");
        System.out.println("Please enter a department id");
        Long id = Long.parseLong(bufferedReader.readLine());
        List<Employee> employees = employeeService.findAllEmployeesByExcludeDepartment(id);
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
    }
}
