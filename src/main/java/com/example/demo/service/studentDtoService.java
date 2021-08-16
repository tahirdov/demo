package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repo.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentDtoService {

    @Autowired
    studentRepo repo;

    public Student getById(long id) {
        return repo.getById(id);
    }

    public void save(Student s) {
        repo.save(s);
    }

    public void update(Long id, Student s) { repo.update(id, s.getName(), s.getSurname(), s.getGpa()); }

    public List<Student> getStudents() {
        return repo.findAll();
    }

    public void delete(Long id) { repo.deleteStudentById(id); }

}
