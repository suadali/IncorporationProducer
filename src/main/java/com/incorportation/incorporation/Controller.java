package com.incorportation.incorporation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("student")
public class Controller {

    private StudentService studentService;

    @Autowired
    public Controller(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("name") String name,@RequestParam("id") String id) {

        Student student=new Student();
        student.setId(Integer.parseInt(id));
        student.setFirstName(name);
        studentService.send(student);

        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        Student studentreal=new Student();
        studentreal.setId(student.getId());
        studentreal.setFirstName(student.getFirstName());
        studentreal.setLastName(student.getLastName());
        studentreal.setEmail(student.getEmail());
        studentreal.setAge(student.getAge());

        studentService.send(studentreal);

        System.out.println(student);
        studentService.addNewStudent(student);
    }
}
