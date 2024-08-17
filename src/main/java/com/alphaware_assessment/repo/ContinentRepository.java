package com.alphaware_assessment.repo;

import com.alphaware_assessment.model.Continent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentRepository extends JpaRepository<Continent, Long> {
    boolean existsByCode(String code);
}
