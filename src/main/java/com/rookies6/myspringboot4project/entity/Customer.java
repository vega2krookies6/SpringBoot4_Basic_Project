package com.rookies6.myspringboot4project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


}
