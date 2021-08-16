package com.example.demo.api;

import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/student")
public class StudentController {

    @Autowired
    private com.example.demo.service.studentDtoService st;

    @GetMapping("/allStudents")
    public List<Student> getAllStudents() {
        return st.getStudents();
    }

    @GetMapping("/find/{id}")
    public Student find(@PathVariable long id) {
        return st.getById(id);
    }

    @PostMapping("/delete/{id}")
    public void deleteStudent(@PathVariable long id) {
        st.delete(id);
    }

    @PostMapping("/update/{student}")
    public void updateStudent(@PathVariable Student student) {
        st.update(student.getId(), student);
    }

    @PostMapping("/save/{student}")
    public void save (@PathVariable Student student) {
        st.save(student);
    }
}