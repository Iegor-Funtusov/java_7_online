package ua.com.alevel.dao.impl;

import ua.com.alevel.config.JdbcConfig;
import ua.com.alevel.dao.EmployeeDao;
import ua.com.alevel.entity.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private final JdbcConfig config = JdbcConfig.getInstance();

    private static final String EMPLOYEE_CREATE_QUERY = "insert into employees values (default, ?, ?, ?)";
    private static final String EMPLOYEE_UPDATE_QUERY = "update employees set first_name = ?, last_name = ?, age = ? where id = ?";
    private static final String EMPLOYEE_DELETE_QUERY = "delete from employees where id = ?";
    private static final String EMPLOYEE_FIND_BY_ID_QUERY = "select * from employees where id = ";
    private static final String EMPLOYEE_FIND_ALL_QUERY = "select * from employees";

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
