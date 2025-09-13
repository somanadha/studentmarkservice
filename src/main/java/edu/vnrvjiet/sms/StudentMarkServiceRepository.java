package edu.vnrvjiet.sms;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentMarkServiceRepository {
    HashMap<Integer, Student> idAndStudentHashMap = new HashMap<>();

    public Student add(Student student) {
        if (student != null && !idAndStudentHashMap.containsKey(student.getId())){
            idAndStudentHashMap.put(student.getId(), student);
        }
        return  student;
    }

    public List<Student> findAll() {
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

    public Student update(Student student) {
        Student existingStudent = null;
        if (student != null && idAndStudentHashMap.containsKey(student.getId())){
            existingStudent =  idAndStudentHashMap.get(student.getId());
            existingStudent.setName(student.getName());
            existingStudent.setMaths(student.getMaths());
            existingStudent.setPhysics(student.getPhysics());
            existingStudent.setChemistry(student.getChemistry());
        }
        return  existingStudent;
    }
}