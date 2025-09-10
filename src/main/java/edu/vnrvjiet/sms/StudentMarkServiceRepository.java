package edu.vnrvjiet.sms;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class StudentMarkServiceRepository {
    HashMap<Integer, Student> idAndStudentHashMap = new HashMap<>();
    public Boolean addOneStudent(Student student) {
        Boolean studetnAdded = false;
        if (!idAndStudentHashMap.containsKey(student.getId())){
            idAndStudentHashMap.put(student.getId(), student);
            studetnAdded = true;
        }
        return  studetnAdded;
    }
}