package edu.vnrvjiet.sms;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentMarkServiceTests {

    @Autowired
    private StudentMarkService studentMarkService;

    @Test
    void contextLoads() {
    }

    @Test
    @Order(1)
    public void addOneStudentTest_1() {
        Student student = new Student(1, "Satya", 100, 99, 98);
        student = studentMarkService.addOneStudent(student);

        assertNotEquals(null, student);
        assertEquals(1, student.getId());
        assertEquals("Satya", student.getName());
        assertEquals(100, student.getMaths());
        assertEquals(99, student.getPhysics());
        assertEquals(98, student.getChemistry());
    }

    @Test
    @Order(2)
    public void addOneStudentTest_2() {
        Student student = new Student(2, "Dev", 98, 99, 100);;
        student = studentMarkService.addOneStudent(student);

        assertNotEquals(null, student);
        assertEquals(2, student.getId());
        assertEquals("Dev", student.getName());
        assertEquals(98, student.getMaths());
        assertEquals(99, student.getPhysics());
        assertEquals(100, student.getChemistry());
    }

    @Test
    @Order(3)
    public void findAllTest_1() {
        List<Student> students = studentMarkService.findAllStudents();

        assertEquals(2, students.size());
        assertEquals("Satya", students.get(0).getName());
        assertEquals("Dev", students.get(1).getName());
    }

    @Test
    @Order(4)
    public void findByIdTest() {
        Student student = studentMarkService.findById(1);

        assertNotEquals(null, student);
        assertEquals("Satya", student.getName());
    }

    @Test
    @Order(5)
    public void deleteByIdTest() {
        Student student = studentMarkService.deleteById(2);

        assertNotEquals(null, student);
        assertEquals(2, student.getId());
        assertEquals("Dev", student.getName());
        assertEquals(98, student.getMaths());
        assertEquals(99, student.getPhysics());
        assertEquals(100, student.getChemistry());
    }

    @Test
    @Order(6)
    public void updateStudentTest_1() {
        Student student = new Student(1, "Satya Dev", 100, 100, 100);;
        student = studentMarkService.updateStudent(student);

        assertNotEquals(null, student);
        assertEquals(1, student.getId());
        assertEquals("Satya Dev", student.getName());
        assertEquals(100, student.getMaths());
        assertEquals(100, student.getPhysics());
        assertEquals(100, student.getChemistry());
    }

    @Test
    @Order(6)
    public void updateStudentTest_2() {
        Student student = new Student(2, "Satya Dev", 0, 0, 0);
        student = studentMarkService.updateStudent(student);

        assertEquals(null, student);
    }

    @Test
    @Order(7)
    public void findAllTest_2() {
        List<Student> students = studentMarkService.findAllStudents();

        assertEquals(1, students.size());

        Student student = students.get(0);
        assertEquals(1, student.getId());
        assertEquals("Satya Dev", student.getName());
        assertEquals(100, student.getMaths());
        assertEquals(100, student.getPhysics());
        assertEquals(100, student.getChemistry());
    }
}
