package com.udacity.jdnd.course3.critter.repositories;

import com.udacity.jdnd.course3.critter.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Aaron
 * @date 3/28/22 6:05 PM
 */
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query(value = "select schedule_id from schedule_employee_ids where employee_ids=:employeeId", nativeQuery = true)
    List<Long> findAllByeId(@Param("employeeId") long employeeId);

    @Query(value = "select schedule_id from schedule_pet_ids where pet_ids=:petId", nativeQuery = true)
    List<Long> findAllBypId(@Param("petId")long petId);
}
