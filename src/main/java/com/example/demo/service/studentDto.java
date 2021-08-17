package com.example.demo.service;

import com.example.demo.entity.Student;
import javassist.NotFoundException;

import java.util.List;

public interface studentDto {

     Student getById(Long id) throws NotFoundException;

     void save(Student s);

     void update(Long id, Student s) throws NotFoundException;

     List<Student> getStudents();

     void delete(Long id) throws NotFoundException;

     boolean doesStudentExist(Long id) throws NotFoundException;
}
