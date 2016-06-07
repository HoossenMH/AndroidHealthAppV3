package com.example.hoossenlenovo.assignment6.restapi;

import java.io.Serializable;

/**
 * Created by hoossenLenovo on 2016-06-07.
 */
public class DateOfBirthResource implements Serializable {

    private Long id;
    private int day;
    private String month;
    private int year;

    private static final long serialVersionUID = 1L;

    public DateOfBirthResource() {
    }

    public DateOfBirthResource(Long id,int day, String month, int year) {
        this.id = id;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Long getId() {
        return id;
    }
    public int getDay() {
        return day;
    }
    public String getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }


    public DateOfBirthResource(Builder builder)
    {
        this.id = builder.id;
        this.day = builder.day;
        this.month = builder.month;
        this.year = builder.year;
    }

    public static class Builder
    {
        private Long id;
        private int day;
        private String month;
        private int year;


        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder day(int value){
            this.day = value;
            return this;
        }
        public Builder month(String value){
            this.month = value;
            return this;
        }
        public Builder year(int value){
            this.year = value;
            return this;
        }

        public Builder copy(DateOfBirthResource value) {
            this.id = value.id;
            this.day = value.day;
            this.month = value.month;
            this.year = value.year;

            return this;
        }

        public DateOfBirthResource build() {
            return new DateOfBirthResource(this);
        }
    }
}
