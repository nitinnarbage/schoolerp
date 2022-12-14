package com.cloverproject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO
{

    private JdbcTemplate jdbcTemplate;
    // JdbcTemplate setter
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Saving a new Employee
    public void saveEmployee(Employee employee)
    {
        String sql = "insert into Employee values(?,?,?,?,?,?,?)";
        System.out.println("dao called");
        jdbcTemplate.update(sql, new Object[]
        { employee.getId(), employee.getName(), employee.getBirthdate(), employee.getGender(),employee.getHobbies(),employee.getAddress(),employee.getPan() });
    }

    // Getting a particular Employee
    public Employee getEmployeeById(int id)
    {
        String sql = "select * from Employee where id=?";
        Employee employee = (Employee) jdbcTemplate.queryForObject(sql, new Object[]
        { id }, new RowMapper<Employee>()
        {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException 
            {
                Employee employee = new Employee();
                employee.setId(rs.getInt(1));
                employee.setName(rs.getString(2));
                employee.setBirthdate(rs.getString(3));
                employee.setGender(rs.getString(4));
                employee.setHobbies(rs.getString(5));
                employee.setAddress(rs.getString(6));
                employee.setPan(rs.getString(7));
                return employee;
            }
        });
        return employee;
    }

    // Getting all the Employees
    public List<Employee> getAllEmployees()
    {
        String sql = "select * from Employee";

        List<Employee> employeeList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Employee>>()
        {
            @Override
            public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException
            {
                List<Employee> list = new ArrayList<Employee>();
                while (rs.next())
                {
                    Employee employee = new Employee();
                    
                    employee.setId(rs.getInt(1));
                    employee.setName(rs.getString(2));
                    employee.setBirthdate(rs.getString(3));
                    employee.setGender(rs.getString(4));
                    employee.setHobbies(rs.getString(5));
                    employee.setAddress(rs.getString(6));
                    employee.setPan(rs.getString(7));
                    
                  
                    list.add(employee);
                }
                return list;
            }

        });
        return employeeList;
    }

    // Updating a particular Employee
    public void updateEmployee(Employee employee)
    {
        String sql = "update Employee set name =?, birthdate=?, gender=?, hobbies=?, address=?, pan=? where id=?";
        jdbcTemplate.update(sql, new Object[]
        { employee.getId(), employee.getName(), employee.getBirthdate(), employee.getGender(),employee.getHobbies(),employee.getAddress(),employee.getPan() });
    }

    // Deletion of a particular Employee
    public void deleteEmployee(int id)
    {
        String sql = "delete from Employee where id=?";
        jdbcTemplate.update(sql, new Object[]
        { id });
    }
}
