package com.marlo.demo.persistence.domain;

import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "RATE_DETAILS")
public class RateDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SUCCESS")
    private String success;

    @Column(name = "BASE")
    private String base;

    @Column(name = "REQUEST_DATE")
    private String date;

    @Column(name = "REQUEST_TIMESTAMP")
    private LocalDateTime timestamp;

    @Column(name = "UPDATED_ON")
    private LocalDateTime updatedOn;

}
