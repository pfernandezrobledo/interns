package com.avanade.interns.sample;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {

    @Query("SELECT s FROM Sample s WHERE s.name = :sampleName")
    Optional<Sample> findByName(@Param("sampleName") String name);

}
