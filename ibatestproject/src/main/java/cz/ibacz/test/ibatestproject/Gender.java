/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ibacz.test.ibatestproject;

/**
 *
 * @author Milan
 */
public enum Gender {
    MALE("Male"), FEMALE("Female");
    
    private String value;
    Gender(final String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }    
}
