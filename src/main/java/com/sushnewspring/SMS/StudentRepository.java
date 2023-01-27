package com.sushnewspring.SMS;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

@Repository
public class StudentRepository {

    HashMap<Integer,Student> db = new HashMap<>();

    public String createStudentInfo(Student student){
        int roll = student.getRollNo();
        db.put(roll,student);
        return "Student added successfully";
    }

    public Student getStudent(int id){
        return db.get(id);
    }

    public String updateStudent(int id,Student newStu){
        if(!db.containsKey(id)){
            return null;
        }
        Student stu = db.get(id);
        stu.setRollNo(newStu.getRollNo());
        stu.setName(newStu.getName());
        stu.setState(newStu.getState());

        return "Student info updated";
    }

    public String deleteStudent(int id){
        if(!db.containsKey(id)){
            return "Invalid Student Id";
        }
        db.remove(id);
        return "Student removed Successfully";
    }

}
