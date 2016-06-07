package com.example.hoossenlenovo.assignment6.restapi;

import com.example.hoossenlenovo.assignment6.designPatterns.domain.UserName;

import java.io.Serializable;

/**
 * Created by Admin on 2016/06/07.
 */
public class UserResource implements Serializable {

    private Long id;
    private String userId;
    private int age;
    private UserName uName;


    
    public int getAge() {        return age;    }
    public String getUserId() {   return userId;  }
    public Long getId() {        return id;    }
    public UserName getUserName() {        return uName;    }

    private UserResource(){}

    public UserResource(Builder builder)
    {
       this.id = builder.id;
        this.userId = builder.userId;
        this.age = builder.age;
        this.uName = builder.uName;
    }

    public static class Builder
    {
        private Long id;
    private String userId;
    private int age;
    private UserName uName;


        public Builder() {
        }

        public Builder(Long id,int chestsAmount, int benchPressAmount, int inclineBenchPressAmount) {
            this.id = id;
        this.userId = userId;
        this.age = age;
        this.uName = uName;
        }


        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder userId(String value){
            this.userId = value;
            return this;
        }
        public Builder age(int value){
            this.age = value;
            return this;
        }
        public Builder uName(UserName value){
            this.uName = value;
            return this;
        }

        public Builder copy(UserResource value) {
            this.id = value.id;
            this.userId = value.userId;
            this.age = value.age;
            this.uName = value.uName;
            return this;
        }

        public UserResource build() {
            return new UserResource(this);
        }
    }

}