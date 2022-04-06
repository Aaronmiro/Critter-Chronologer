package com.udacity.jdnd.course3.critter.schedule;


import com.google.common.collect.Lists;
import com.udacity.jdnd.course3.critter.entities.Schedule;
import com.udacity.jdnd.course3.critter.services.PetService;
import com.udacity.jdnd.course3.critter.services.ScheduleService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final PetService petService;

    public ScheduleController(ScheduleService scheduleService, PetService petService) {
        this.scheduleService = scheduleService;
        this.petService = petService;
    }

    private Schedule convertTDOToSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();
        BeanUtils.copyProperties(scheduleDTO, schedule);
        return schedule;
    }

    private ScheduleDTO convertToScheduleDTO(Schedule schedule) {
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        BeanUtils.copyProperties(schedule, scheduleDTO);
        scheduleDTO.setEmployeeIds(Lists.newArrayList(schedule.getEmployeeIds()));
        scheduleDTO.setPetIds(Lists.newArrayList(schedule.getPetIds()));
        return scheduleDTO;
    }

    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        Schedule schedule = scheduleService.createSchedule(convertTDOToSchedule(scheduleDTO));
        return convertToScheduleDTO(schedule);
    }

    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        return scheduleService.getAll().stream().map(this::convertToScheduleDTO).collect(Collectors.toList());
    }

    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
        return scheduleService.getSchedulesBypId(petId).stream().map(this::convertToScheduleDTO).collect(Collectors.toList());
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        return scheduleService.getSchedulesByeId(employeeId).stream().map(this::convertToScheduleDTO).collect(Collectors.toList());
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
        List<Long> petIds = petService.getIdsByOwnerId(customerId);
        List<Schedule> scheduleList = new ArrayList<>();
        for (Long petId : petIds) {
            scheduleList.addAll(scheduleService.getSchedulesBypId(petId));
        }
        return scheduleList.stream().map(this::convertToScheduleDTO).collect(Collectors.toList());
    }
}
