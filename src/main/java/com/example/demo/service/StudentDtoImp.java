package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repo.studentRepo;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentDtoImp implements studentDto {

    private final studentRepo repo;

    public StudentDtoImp(studentRepo repo) {
        this.repo = repo;
    }

    @Override
    public Student getById(Long id) throws NotFoundException {
        if (doesStudentExist(id)) throw new NotFoundException("Student not found");
        else return repo.getById(id);
    }

    @Override
    public void save(Student s) {
        repo.save(s);
    }

    @Override
    public void update(Long id, Student s) throws NotFoundException {
        if (doesStudentExist(id)) throw new NotFoundException("Student not found");
        else repo.update(id, s.getName(), s.getSurname(), s.getGpa());
    }

    @Override
    public List<Student> getStudents() {
        return repo.findAll();
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        if (doesStudentExist(id)) throw new NotFoundException("Student not found");
        else repo.deleteStudentById(id);
    }

    @Override
    public boolean doesStudentExist(Long id) {
        return repo.findById(id).isEmpty();
    }

}
