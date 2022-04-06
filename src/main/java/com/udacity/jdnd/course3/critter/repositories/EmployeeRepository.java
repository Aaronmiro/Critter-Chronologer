package com.udacity.jdnd.course3.critter.repositories;

import com.udacity.jdnd.course3.critter.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Aaron
 * @date 3/25/22 10:55 AM
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "Select * from employee e, employee_days_available d where e.id = d.employee_id and d.days_available=:value", nativeQuery = true)
    List<Employee> findByDate(@Param("value") int value);

//    @Query(value = "Select e.id from employee e where e.schedule_id=:scheduleId", nativeQuery = true)
//    List<Long> findAllByScheduleId(@Param("scheduleId") Long scheduleId);
}
