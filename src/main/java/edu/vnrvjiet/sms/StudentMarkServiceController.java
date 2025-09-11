package edu.vnrvjiet.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("sms")
@RestController
public class StudentMarkServiceController {
    @Autowired
    private  StudentMarkService studentMarkService;

    @PostMapping("addOne")
    public ResponseEntity<Integer> addOneStudent(@RequestBody Student student) {
        ResponseEntity<Integer> addOneResponse;
        HttpStatus httpStatus = HttpStatus.OK;
        Integer studentId = student.getId();

        try {
            Boolean studentAdded = studentMarkService.addOneStudent(student);
            if (!studentAdded) {
                studentId = -1;
            }
            httpStatus = HttpStatus.CREATED;
        }
        catch (Exception exception) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            System.out.println("Exception:"+exception.getMessage());
        }
        finally {
            addOneResponse = new ResponseEntity<>(studentId, httpStatus);
        }
        return addOneResponse;
    }

    @PostMapping("addMulti")
    public ResponseEntity<List<Integer>> addMultipleStudents(@RequestBody List<Student> students) {
        ResponseEntity<List<Integer>> responseEntity;
        List<Integer> addedStudents = new ArrayList<>();
        HttpStatus httpStatus = HttpStatus.OK;

        try {
            Boolean studentAdded = true;
            for(Student student : students) {
                studentAdded = studentAdded && studentMarkService.addOneStudent(student);
                if (studentAdded) {
                    addedStudents.add(student.getId());
                }
            }
            httpStatus = HttpStatus.CREATED;
        }
        catch (Exception exception) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            System.out.println("Exception:"+exception.getMessage());
        }
        finally {
            responseEntity = new ResponseEntity<>(addedStudents, httpStatus);
        }
        return responseEntity;
    }

    @GetMapping("findAll")
    public ResponseEntity<List<Student>> findAllStudents() {

        ResponseEntity<List<Student>> responseEntity;
        List<Student> studentList = null;
        HttpStatus httpStatus = HttpStatus.OK;

        try {
            studentList = studentMarkService.findAllStudents();
            httpStatus = HttpStatus.CREATED;
        }
        catch (Exception exception) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            System.out.println("Exception:"+exception.getMessage());
        }
        finally {
            responseEntity = new ResponseEntity<>(studentList, httpStatus);
        }
        return responseEntity;
    }
    @GetMapping("findById")
    public ResponseEntity<Student> findById(Integer id) {

        ResponseEntity<Student> responseEntity;
        Optional<Student> student  = Optional.empty();
        HttpStatus httpStatus = HttpStatus.OK;

        try {
            student = studentMarkService.findById(id);
        }
        catch (Exception exception) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            System.out.println("Exception:"+exception.getMessage());
        }
        finally {
            responseEntity = new ResponseEntity<>(student.orElse(null), httpStatus);
        }
        return responseEntity;
    }
}

