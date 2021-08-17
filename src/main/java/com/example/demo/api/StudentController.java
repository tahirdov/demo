package com.example.demo.api;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentDtoImp;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/student")
public class StudentController {

    private final StudentDtoImp st;

    public StudentController(StudentDtoImp imp) {
        st = imp;
    }

    @GetMapping("/allStudents")
    public List<Student> getAllStudents() {
        return st.getStudents();
    }

    @GetMapping("/find/{id}")
    public Student find(@PathVariable long id) throws NotFoundException {
        return st.getById(id);
    }

    @PostMapping("/delete/{id}")
    public void deleteStudent(@PathVariable long id) throws NotFoundException {
        st.delete(id);
    }

    @PostMapping("/update/{student}")
    public void updateStudent(@PathVariable Student student) throws NotFoundException  {
        st.update(student.getId(), student);
    }

    @PostMapping("/save/{student}")
    public void save (@PathVariable Student student) {
        st.save(student);
    }
}
