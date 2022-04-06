package com.udacity.jdnd.course3.critter.services;

import com.udacity.jdnd.course3.critter.entities.Employee;
import com.udacity.jdnd.course3.critter.repositories.EmployeeRepository;
import com.udacity.jdnd.course3.critter.user.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import org.springframework.stereotype.Service;

import java.nio.channels.FileChannel;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Aaron
 * @date 3/25/22 10:58 AM
 */
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee) {
        return this.employeeRepository.save(employee);
    }


    public Employee getById(long employeeId) {
        return this.employeeRepository.getOne(employeeId);
    }

    public void setAvailability(Set<DayOfWeek> daysAvailable, long employeeId) {
        Employee employee = employeeRepository.getOne(employeeId);
        employee.setDaysAvailable(daysAvailable);
        employeeRepository.save(employee);
    }


    public List<Employee> findEmployeesForService(LocalDate date, Set<EmployeeSkill> skills) {
        List<Employee> employeeList = employeeRepository.findByDate(date.getDayOfWeek().getValue() - 1);
        return employeeList.stream().filter(employee -> employee.getSkills().containsAll(skills)).collect(Collectors.toList());
    }


//    public List<Long> getIdsByScheduleId(long scheduleId) {
//        List<Long> allByScheduleId = employeeRepository.findAllByScheduleId(scheduleId);
//        return allByScheduleId;
//    }
}
