package com.sushnewspring.SMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create_students")
    public ResponseEntity createStudentInfo(@RequestBody() Student student){
        String response = studentService.addStudent(student);
        return new ResponseEntity<>(response, HttpStatus.CREATED) ;
    }

    @GetMapping("/get_student/{idNo}")
    public ResponseEntity getStudent(@PathVariable("idNo") int id){

        return new ResponseEntity<>(studentService.getStudent(id), HttpStatus.FOUND);
    }

    @PutMapping("/update_student/{id}")
    public ResponseEntity updateStudent( @PathVariable("id") int id, @RequestBody() Student newStu){
        String response = studentService.updateStudent(id,newStu);
        if(response==null){
            return new ResponseEntity<>("Invalid Id", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED) ;

    }

    @DeleteMapping("/del_student/{roll}")
    public ResponseEntity deleteStudent(@PathVariable("roll") int id){
        String response =  studentService.deleteStudent(id);
        if(response.equals("Invalid Student Id")){
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }

}
