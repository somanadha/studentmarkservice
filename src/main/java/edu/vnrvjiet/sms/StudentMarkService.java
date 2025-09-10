package edu.vnrvjiet.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentMarkService {
    @Autowired
    StudentMarkServiceRepository studentMarkServiceRepository;

    public Boolean addOneStudent(Student student) {
        return studentMarkServiceRepository.addOneStudent(student);
    }
}
