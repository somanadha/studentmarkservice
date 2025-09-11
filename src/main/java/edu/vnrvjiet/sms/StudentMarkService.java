package edu.vnrvjiet.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentMarkService {
    @Autowired
    StudentMarkServiceRepository studentMarkServiceRepository;

    public Boolean addOneStudent(Student student) {
        return studentMarkServiceRepository.addOneStudent(student);
    }

    public List<Student> findAllStudents() {
        return studentMarkServiceRepository.findAllStudents();
    }

    public Optional<Student> findById(Integer id) {
        return studentMarkServiceRepository.findById(id);
    }
}
