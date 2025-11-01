package edu.vnrvjiet.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sms")
public class StudentMarkServiceController {
    @Autowired
    private  StudentMarkService studentMarkService;

    @PostMapping("addOne")
    public ResponseEntity<Student> addOneStudent(@RequestBody Student student) {
        student = studentMarkService.addOneStudent(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @GetMapping("findAll")
    public ResponseEntity<List<Student>> findAllStudents() {
        List<Student> studentList = studentMarkService.findAllStudents();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @GetMapping("findById")
    public ResponseEntity<Student> findById(Integer id) {
        Student student = studentMarkService.findById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("deleteById")
    public ResponseEntity<Student> deleteById(Integer id) {
        Student student = studentMarkService.deleteById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        student = studentMarkService.updateStudent(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}