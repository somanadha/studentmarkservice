package edu.vnrvjiet.sms;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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

    public List<Student> findAllStudents() {
        return new ArrayList<>(idAndStudentHashMap.values());
    }

    public Optional<Student> findById(Integer id) {
        if (idAndStudentHashMap.containsKey(id)){
            return Optional.of(idAndStudentHashMap.get(id));
        }
        return  Optional.empty();
    }
}