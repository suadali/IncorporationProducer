package com.incorportation.incorporation;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }

    @Autowired
    private AmqpTemplate rabbitTemplate;

//    @Value("${javainuse.rabbitmq.exchange}")
//    private String exchange;
//
//    @Value("${javainuse.rabbitmq.routingkey}")
//    private String routingkey;

    public void send(Student student) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.exchange, RabbitMQConfig.routingkey, student);
        System.out.println("Send msg = " + student);

    }
}
