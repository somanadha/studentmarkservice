package edu.vnrvjiet.sms;

import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentMarkServiceRepository {
    HashMap<Integer, Student> idAndStudentHashMap = new HashMap<>();

    public Student addOneStudent(Student student) {
        if (student != null && !idAndStudentHashMap.containsKey(student.getId())){
            idAndStudentHashMap.put(student.getId(), student);
        }
        return  student;
    }

    public List<Student> findAllStudents() {
        return new ArrayList<>(idAndStudentHashMap.values());
    }

    public Student findById(Integer id) {
        Student student = null;
        if (id!= null && idAndStudentHashMap.containsKey(id)){
            student = idAndStudentHashMap.get(id);
        }
        return  student;
    }

    public Student deleteById(Integer id) {
        Student student = null;
        if (id!= null && idAndStudentHashMap.containsKey(id)){
            student = idAndStudentHashMap.get(id);
            idAndStudentHashMap.remove(id);
        }
        return student;
    }
}