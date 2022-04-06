package com.udacity.jdnd.course3.critter.entities;

import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * @author Aaron
 * @date 3/28/22 2:59 PM
 */
@Entity
@Getter
@Setter
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate date;

    @ElementCollection
    private Set<EmployeeSkill> activities;

    @ElementCollection
    private List<Long> employeeIds;

    @ElementCollection
    private List<Long> petIds;


}
