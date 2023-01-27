package com.sushnewspring.SMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student){
        return studentRepository.createStudentInfo(student);
    }

    public Student getStudent(int id){

        return studentRepository.getStudent(id);
    }

    public String updateStudent(int id,Student student){
        return studentRepository.updateStudent(id,student);
    }

    public String deleteStudent(int id){

        return studentRepository.deleteStudent(id);
    }
}
