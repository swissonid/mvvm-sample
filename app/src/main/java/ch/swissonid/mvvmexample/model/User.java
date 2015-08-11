package ch.swissonid.mvvmexample.model;

import java.util.Date;

/**
 * Created by pmueller on 10.8.15.
 */
public class User {
    private String name;
    private String lastName;
    private String email;
    private Date birthDay;

    public User(final String name, final String lastName, final String email, final Date birthDay) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(final Date birthDay) {
        this.birthDay = birthDay;
    }
}
