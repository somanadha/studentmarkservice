package edu.vnrvjiet.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("sms")
@RestController
public class StudentMarkServiceController {
    @Autowired
    private  StudentMarkService studentMarkService;

    @PostMapping("addOne")
    public ResponseEntity<Student> addOneStudent(@RequestBody Student student) {
        ResponseEntity<Student> responseEntity;
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
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
            if (studentList.isEmpty()) {
                httpStatus = HttpStatus.NO_CONTENT;
            }
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
            if (student == null) {
                httpStatus = HttpStatus.NO_CONTENT;
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

    @DeleteMapping("deleteById")
    public ResponseEntity<Student> deleteById(Integer id) {
        ResponseEntity<Student> responseEntity;
        Student student  = null;
        HttpStatus httpStatus = HttpStatus.OK;

        try {
            student = studentMarkService.deleteById(id);
            if (student == null){
                httpStatus = HttpStatus.NO_CONTENT;
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

    @PutMapping("update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        ResponseEntity<Student> responseEntity;
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        Integer studentId = student.getId();

        try {
            student = studentMarkService.updateStudent(student);
            if (student != null) {
                httpStatus = HttpStatus.OK;
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
}