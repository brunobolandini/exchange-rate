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

    @Column(name = "DATE")
    private String date;

    @Column(name = "TIMESTAMP")
    private LocalDateTime timestamp;

    @Column(name = "UPDATED_ON")
    private LocalDateTime updatedOn;

}
