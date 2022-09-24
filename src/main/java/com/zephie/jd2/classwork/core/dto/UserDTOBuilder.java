package com.zephie.jd2.classwork.core.dto;

import java.time.LocalDate;

public class UserDTOBuilder {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    private UserDTOBuilder() {
    }

    public static UserDTOBuilder create() {
        return new UserDTOBuilder();
    }

    public UserDTOBuilder setLogin(String login) {
        this.login = login;
        return this;
    }

    public UserDTOBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserDTOBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserDTOBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserDTOBuilder setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public UserDTO build() {
        return new UserDTO(login, password, firstName, lastName, birthDate);
    }
}
