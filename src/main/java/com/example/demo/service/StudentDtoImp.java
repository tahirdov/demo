package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repo.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDtoImp implements studentDto {

    private final studentRepo repo;

    public StudentDtoImp(studentRepo repo) {
        this.repo = repo;
    }

    @Override
    public Student getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public void save(Student s) {
        repo.save(s);
    }

    @Override
    public void update(Long id, Student s) {
        repo.update(id, s.getName(), s.getSurname(), s.getGpa());
    }

    @Override
    public List<Student> getStudents() {
        return repo.findAll();
    }

    @Override
    public void delete(Long id) {
        repo.deleteStudentById(id);
    }

}
