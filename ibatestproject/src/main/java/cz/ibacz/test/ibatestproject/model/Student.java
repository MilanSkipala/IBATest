/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ibacz.test.ibatestproject.model;

import cz.ibacz.test.ibatestproject.Gender;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Length.List;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Milan
 */
public class Student {
    private Long id;

    
    @List({
        @Length(min = 1, message = "The first name must not be empty"),
        @Length(max = 60, message = "The first name must be shorter than 60 characters")
    })
    private String firstName;
    
    @List({
        @Length(min = 1, message = "The first name must not be empty"),
        @Length(max = 60, message = "The first name must be shorter than 60 characters")
    })
    private String surname;

    @NotNull(message = "Must not be empty")
    @Past(message = "The date of birth has to be in the past")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date dateOfBirth;
    private Gender gender;
   
    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (this.id == null)
            this.id = id;
    }
}
