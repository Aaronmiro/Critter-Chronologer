package com.udacity.jdnd.course3.critter.repositories;

import com.udacity.jdnd.course3.critter.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Aaron
 * @date 3/25/22 12:16 PM
 */
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    @Query(value = "select * from pet where owner_id=:ownerId", nativeQuery = true)
    List<Pet> findByOwnerId(@Param("ownerId") long ownerId);

    @Query(value = "select pet.id from pet where owner_id=:ownerId", nativeQuery = true)
    List<Long> findAllIdsByOwnerId(@Param("ownerId") long ownerId);

//    @Query(value = "Select pet.id from pet where schedule_id=:scheduleId", nativeQuery = true)
//    List<Long> findAllByScheduleId(@Param("scheduleId") Long scheduleId);
}
