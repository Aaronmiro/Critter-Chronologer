package com.udacity.jdnd.course3.critter.services;

import com.udacity.jdnd.course3.critter.entities.Schedule;
import com.udacity.jdnd.course3.critter.repositories.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Aaron
 * @date 3/28/22 6:05 PM
 */
@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }

    public List<Schedule> getSchedulesByeId(long employeeId) {
        List<Long> scheduleIds = scheduleRepository.findAllByeId(employeeId);
        return scheduleRepository.findAllById(scheduleIds);
    }

    public List<Schedule> getSchedulesBypId(long petId) {
        List<Long> scheduleIds = scheduleRepository.findAllBypId(petId);
        return scheduleRepository.findAllById(scheduleIds);
    }
}
