package edu.vnrvjiet.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentMarkService {
    @Autowired
    StudentMarkServiceRepository studentMarkServiceRepository;

    public Student addOneStudent(Student student) {
        return studentMarkServiceRepository.addOneStudent(student);
    }

    public List<Student> findAllStudents() {
        return studentMarkServiceRepository.findAllStudents();
    }

    public Student findById(Integer id) {
        return studentMarkServiceRepository.findById(id);
    }

    public Student deleteById(Integer id) {
        return studentMarkServiceRepository.deleteById(id);
    }
}
