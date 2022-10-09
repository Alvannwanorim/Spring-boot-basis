package com.alvan.springbasis.student;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;
@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    private Long id;
    private String email;
    private LocalDate dob;
    private String name;
    @Transient
    private Integer age;

    public Student() {
    }

    public Student(String email, 
                    LocalDate dob, 
                    String name
                    ) {
        this.email = email;
        this.dob = dob;
        this.name = name;
        
    }

    public Student(Long id, 
                    String email, 
                    LocalDate dob, 
                    String name
                    ) {
        this.id = id;
        this.email = email;
        this.dob = dob;
        this.name = name;
    }
    
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", email=" + email + ", dob=" + dob + ", name=" + name + ", age=" + age + "]";
    }
    

  


}
