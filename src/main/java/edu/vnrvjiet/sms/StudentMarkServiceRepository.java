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

    public Optional<Student> addOneStudent(Student student) {
        if (student != null && !idAndStudentHashMap.containsKey(student.getId())){
            idAndStudentHashMap.put(student.getId(), student);
            return Optional.of(student);
        }
        return  Optional.empty();
    }

    public List<Student> findAllStudents() {
        return new ArrayList<>(idAndStudentHashMap.values());
    }

    public Optional<Student> findById(Integer id) {
        if (idAndStudentHashMap.containsKey(id)){
            return Optional.of(idAndStudentHashMap.get(id));
        }
        return  Optional.empty();
    }

    public Optional<Student> deleteById(Integer id) {
        Optional<Student> student = Optional.empty();
        if (idAndStudentHashMap.containsKey(id)){
            student = Optional.of(idAndStudentHashMap.get(id));
            idAndStudentHashMap.remove(id);
        }
        return student;
    }
}