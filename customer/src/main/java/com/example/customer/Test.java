package com.example.customer;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TEST")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;

    private String username;
}