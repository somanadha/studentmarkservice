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
    public ResponseEntity<Student> addOneStudent(@RequestBody Student student) {
        ResponseEntity<Student> responseEntity;
        HttpStatus httpStatus = HttpStatus.OK;
        Integer studentId = student.getId();

        try {
            student = studentMarkService.addOneStudent(student);
            if (student != null) {
                httpStatus = HttpStatus.CREATED;
            }
        }
        catch (Exception exception) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            System.out.println("Exception:"+exception.getMessage());
        }
        finally {
            responseEntity = new ResponseEntity<>(student, httpStatus);
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
        Student student  = null;
        HttpStatus httpStatus = HttpStatus.OK;

        try {
            student = studentMarkService.findById(id);
        }
        catch (Exception exception) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            System.out.println("Exception:"+exception.getMessage());
        }
        finally {
            responseEntity = new ResponseEntity<>(student, httpStatus);
        }
        return responseEntity;
    }

    @GetMapping("deleteById")
    public ResponseEntity<Student> deleteById(Integer id) {

        ResponseEntity<Student> responseEntity;
        Student student  = null;
        HttpStatus httpStatus = HttpStatus.OK;

        try {
            student = studentMarkService.deleteById(id);
        }
        catch (Exception exception) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            System.out.println("Exception:"+exception.getMessage());
        }
        finally {
            responseEntity = new ResponseEntity<>(student, httpStatus);
        }
        return responseEntity;
    }
}

