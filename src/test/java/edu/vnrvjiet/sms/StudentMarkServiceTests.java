package edu.vnrvjiet.sms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentMarkServiceTests {
    @Mock
    private StudentMarkServiceRepository studentMarkServiceRepository;

    @InjectMocks
    private StudentMarkService studentMarkService;

    @Test
    public void addOneStudentTest() {
        Student student = new Student(1, "Satya", 100, 100, 100);
        studentMarkService.addOneStudent(student);
        student = studentMarkServiceRepository.findById(1);
        //assertNotEquals(null, student);
        //assertEquals("Satya", student.getName());
    }
}
