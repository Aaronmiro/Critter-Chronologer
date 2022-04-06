package com.udacity.jdnd.course3.critter.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Aaron
 * @date 3/23/22 4:55 PM
 */
@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String phoneNumber;

}
