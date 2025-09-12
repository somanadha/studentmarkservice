package edu.vnrvjiet.sms;

import lombok.AllArgsConstructor;
import lombok.Data;

// this is the Domain object
@Data
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private Integer maths;
    private Integer physics;
    private Integer chemistry;
}
