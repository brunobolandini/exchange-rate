package com.marlo.demo.persistence.repository;

import com.marlo.demo.persistence.domain.RateDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends JpaRepository<RateDetailsEntity, Long> {


    RateDetailsEntity save(RateDetailsEntity rateDetailsEntity);


}
