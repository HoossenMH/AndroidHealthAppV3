package com.example.hoossenlenovo.assignment6.restapi;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.DateOfBirth;
import com.example.hoossenlenovo.assignment6.designPatterns.domain.SignUp;
import com.example.hoossenlenovo.assignment6.designPatterns.domain.UserName;

import java.io.Serializable;

/**
 * Created by Admin on 2016/06/07.
 */
public class SignUpResource implements Serializable {

    private UserName uName;
    private Long id;

    private String username;
    private String password;
    private int age;
    private String email;
    private String gender;

    private DateOfBirth dob;

    
    public UserName getUName() {
        return uName;
    }
    public Long getId() { return id; }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public int getAge() {
        return age;
    }
    public String getEmail() {
        return email;
    }
    public String getGender() {
        return gender;
    }

    public DateOfBirth getDob() {
        return dob;
    }


    private SignUpResource(){}

    public SignUpResource(Builder builder)
    {       
		this.id = builder.id;
        this.uName = builder.uName;

        this.username = builder.username;
        this.password = builder.password;
        this.age = builder.age;
        this.email = builder.email;
        this.gender = builder.gender;

        this.dob = builder.dob;
    }

    public static class Builder
    {
        private Long id;
        private UserName uName;

        private String username;
        private String password;
        private int age;
        private String email;
        private String gender;

        private DateOfBirth dob;




        public Builder() {
        }

        public Builder(Long id,UserName uName, String username, String password, int age, String email, String gender, DateOfBirth dob)
        {

            this.uName = uName;
            this.id = id;

            this.username = username;
            this.password = password;
            this.age = age;
            this.email = email;
            this.gender = gender;

            this.dob = dob;
        }


         public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder uName(UserName value){
            this.uName = value;
            return this;
        }

        public Builder username(String value){
            this.username = value;
            return this;
        }

        public Builder password(String value){
            this.password = value;
            return this;
        }

        public Builder age(int value){
            this.age = value;
            return this;
        }

        public Builder email(String value){
            this.email = value;
            return this;
        }

        public Builder gender(String value){
            this.gender = value;
            return this;
        }

        public Builder dob(DateOfBirth value){
            this.dob = value;
            return this;
        }

        public Builder copy(SignUpResource value) {
            this.id = value.id;

            this.uName = value.uName;

            this.username = value.username;
            this.password = value.password;
            this.age = value.age;
            this.email = value.email;
            this.gender = value.gender;

            this.dob = value.dob;

            return this;
        }

        public SignUpResource build() {  return new SignUpResource(this);  }
    }


}