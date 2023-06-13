package com.example.QLSV.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NotFound;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "Class")
    private String lop;

    @Column(name = "Khoa")
    private String khoa;

}
