package com.example.hoossenlenovo.assignment6.restapi;

import java.io.Serializable;

/**
 * Created by hoossenLenovo on 2016-06-07.
 */
public class LoginResource implements Serializable {

    private Long id;
    private String userName;
    private String password;


    private static final long serialVersionUID = 1L;


    public LoginResource(Long id,String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }
    public String getUserName() { return userName;    }
    public String getPassword() {
        return password;
    }


    public LoginResource(Builder builder)
    {
        this.userName = builder.userName;
        this.password = builder.password;
        this.id = builder.id;
    }

    public static class Builder
    {
        private Long id;
        private String userName;
        private String password;

        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder userName(String value){
            this.userName = value;
            return this;
        }
        public Builder password(String value){
            this.password = value;
            return this;
        }

        public Builder copy(LoginResource value) {
            this.id = value.id;
            this.userName = value.userName;
            this.password = value.password;
            return this;
        }

        public LoginResource build() {
            return new LoginResource(this);
        }
    }

}
