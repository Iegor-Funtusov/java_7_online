package ua.com.alevel.dao.impl;

import ua.com.alevel.annotations.BeanClass;
import ua.com.alevel.config.JdbcConfig;
import ua.com.alevel.dao.EmployeeDao;
import ua.com.alevel.entity.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@BeanClass
public class EmployeeDaoImpl implements EmployeeDao {

    private final JdbcConfig config = JdbcConfig.getInstance();

    private static final String EMPLOYEE_CREATE_QUERY = "insert into employees values (default, ?, ?, ?)";
    private static final String EMPLOYEE_UPDATE_QUERY = "update employees set first_name = ?, last_name = ?, age = ? where id = ?";
    private static final String EMPLOYEE_DELETE_QUERY = "delete from employees where id = ?";
    private static final String EMPLOYEE_FIND_BY_ID_QUERY = "select * from employees where id = ";
    private static final String EMPLOYEE_FIND_ALL_QUERY = "select * from employees";
    private static final String EXISTS_EMPLOYEE_BY_ID_QUERY = "select count(*) as count from employees where id = ";
    private static final String EMPLOYEE_FIND_BY_DEPARTMENT_QUERY = "select id, first_name, last_name, age from employees as emp left join dep_emp as de on emp.id = de.emp_id where de.dep_id = ";
    private static final String EMPLOYEE_FIND_BY_EXCLUDE_DEPARTMENT_QUERY = "select * from employees where id not in (" +
            "    select id from employees as emp left join dep_emp as de on emp.id = de.emp_id where de.dep_id = ?" +
            "    )";

    @Override
    public void create(Employee entity) {
        try(PreparedStatement ps = config.getConnection().prepareStatement(EMPLOYEE_CREATE_QUERY)) {
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setInt(3, entity.getAge());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e);
        }
    }

    @Override
    public void update(Employee entity) {
        try(PreparedStatement ps = config.getConnection().prepareStatement(EMPLOYEE_UPDATE_QUERY)) {
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setInt(3, entity.getAge());
            ps.setLong(4, entity.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e);
        }
    }

    @Override
    public void delete(Long id) {
        try(PreparedStatement ps = config.getConnection().prepareStatement(EMPLOYEE_DELETE_QUERY)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e);
        }
    }

    @Override
    public boolean existsById(Long id) {
        try(ResultSet rs = config.getStatement().executeQuery(EXISTS_EMPLOYEE_BY_ID_QUERY + id)) {
            while (rs.next()) {
                Long count = rs.getLong("count");
                return count > 0;
            }
        } catch (SQLException e) {
            System.out.println("e = " + e);
        }
        return false;
    }

    @Override
    public Employee findById(Long id) {
        try(ResultSet rs = config.getStatement().executeQuery(EMPLOYEE_FIND_BY_ID_QUERY + id)) {
            while (rs.next()) {
                return buildEmployeeByResultSet(rs);
            }
        } catch (SQLException e) {
            System.out.println("e = " + e);
        }
        return null;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        try(ResultSet rs = config.getStatement().executeQuery(EMPLOYEE_FIND_ALL_QUERY)) {
            while (rs.next()) {
                employees.add(buildEmployeeByResultSet(rs));
            }
            return employees;
        } catch (SQLException e) {
            System.out.println("e = " + e);
        }
        return employees;
    }

    @Override
    public List<Employee> findAllEmployeesByDepartment(Long departmentId) {
        List<Employee> employees = new ArrayList<>();
        try(ResultSet rs = config.getStatement().executeQuery(EMPLOYEE_FIND_BY_DEPARTMENT_QUERY + departmentId)) {
            while (rs.next()) {
                employees.add(buildEmployeeByResultSet(rs));
            }
            return employees;
        } catch (SQLException e) {
            System.out.println("e = " + e);
        }
        return employees;
    }

    @Override
    public List<Employee> findAllEmployeesByExcludeDepartment(Long departmentId) {
        List<Employee> employees = new ArrayList<>();
        try(PreparedStatement ps = config.getConnection().prepareStatement(EMPLOYEE_FIND_BY_EXCLUDE_DEPARTMENT_QUERY)) {
            ps.setLong(1, departmentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                employees.add(buildEmployeeByResultSet(rs));
            }
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return employees;
    }

    private Employee buildEmployeeByResultSet(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        Integer age = rs.getInt("age");
        Employee employee = new Employee();
        employee.setId(id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAge(age);
        return employee;
    }
}
