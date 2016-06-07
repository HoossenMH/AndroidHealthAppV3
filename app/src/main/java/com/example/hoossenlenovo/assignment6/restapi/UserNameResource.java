package com.example.hoossenlenovo.assignment6.restapi;

import java.io.Serializable;

/**
 * Created by hoossenLenovo on 2016-06-07.
 */
public class UserNameResource implements Serializable
{
    private Long id;
    private String firstName;
    private String lastName;

    private static final long serialVersionUID = 1L;

    public UserNameResource()
    {}

    public UserNameResource(Long id,String firstName, String lastName)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Long getId() {
        return id;
    }
    public String getFirstName() { return firstName; }
    public String getLastName() {
        return lastName;
    }



    public UserNameResource(Builder builder)
    {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public static class Builder
    {
        private Long id;
        private String firstName;
        private String lastName;

        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder firstName(String value){
            this.firstName = value;
            return this;
        }
        public Builder lastName(String value){
            this.lastName = value;
            return this;
        }

        public Builder copy(UserNameResource value) {
            this.id = value.id;
            this.firstName = value.firstName;
            this.lastName = value.lastName;
            return this;
        }

        public UserNameResource build() {
            return new UserNameResource(this);
        }
    }
}
