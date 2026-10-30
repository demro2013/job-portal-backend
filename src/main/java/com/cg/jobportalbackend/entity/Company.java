package com.cg.jobportalbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
@Getter @Setter @ToString
public class Company extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 255)
    private String name;

    @Column(length = 500)
    private String logo;

    @Column(nullable = false, length = 100)
    private String industry;

    @Column(nullable = false, length = 50)
    private String size;

    @Column(nullable = false, precision = 3, scale = 2)
    private BigDecimal rating;

    @Column(length = 1000)
    private String locations;

    @Column(nullable = false)
    private Integer founded;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private Integer employees;

    @Column(length = 500)
    private String website;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Job> jobs = new ArrayList<>();
}
