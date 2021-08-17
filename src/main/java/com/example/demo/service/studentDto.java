package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;

public interface studentDto {

     Student getById(Long id);

     void save(Student s);

     void update(Long id, Student s);

     List<Student> getStudents();

     void delete(Long id);
}
