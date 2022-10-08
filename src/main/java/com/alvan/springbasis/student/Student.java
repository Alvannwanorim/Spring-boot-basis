package com.alvan.springbasis.student;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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
    private Integer age;
    public Student(long l, String string, String string2, LocalDate localDate, int i) {
    }
    public Student(Long id, 
                    String email, 
                    LocalDate dob, 
                    String name, 
                    Integer age) {
        this.id = id;
        this.email = email;
        this.dob = dob;
        this.name = name;
        this.age = age;
    }
    public Student(String email, 
                    LocalDate dob, 
                    String name, 
                    Integer age) {
        this.email = email;
        this.dob = dob;
        this.name = name;
        this.age = age;
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
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", email=" + email + ", dob=" + dob + ", name=" + name + ", age=" + age + "]";
    }
    

  


}
