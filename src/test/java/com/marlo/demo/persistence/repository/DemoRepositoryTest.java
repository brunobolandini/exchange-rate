package com.marlo.demo.persistence.repository;

import java.time.LocalDateTime;

import com.marlo.demo.persistence.domain.RateDetailsEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = "test")
public class DemoRepositoryTest {

    private final Logger log = LoggerFactory.getLogger(DemoRepositoryTest.class);

    @Autowired
    DemoRepository demoRepository;

    @Test
    public void saveTest() {
        RateDetailsEntity rateDetailsEntityResponse = demoRepository.save(createRateDetailsEntity());
        log.debug("Record was inserted to database: {}", rateDetailsEntityResponse.getSuccess());
        assertThat(rateDetailsEntityResponse).isNotNull();
        assertThat(rateDetailsEntityResponse.getSuccess()).isEqualTo("true");
    }

    private RateDetailsEntity createRateDetailsEntity() {
        RateDetailsEntity rateDetailsEntity = new RateDetailsEntity();
        rateDetailsEntity.setSuccess("true");
        rateDetailsEntity.setBase("USD");
        rateDetailsEntity.setDate("01-08-2020");
        rateDetailsEntity.setTimestamp(LocalDateTime.now());
        return rateDetailsEntity;
    }


}
