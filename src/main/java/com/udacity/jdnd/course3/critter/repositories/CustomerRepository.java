package com.udacity.jdnd.course3.critter.repositories;

import com.udacity.jdnd.course3.critter.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Aaron
 * @date 3/25/22 10:08 AM
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
