package com.example.demo.repo;


import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface studentRepo  extends JpaRepository<Student, Long> {
    Optional<Student> findById(Long id);

    @Override
    <S extends Student> S save(S entity);

    @Override
    List<Student> findAll();

    void deleteStudentById(Long id);

    @Modifying
    @Query("update Student u set u.name =: name, u.surname =: surname, u.gpa =: gpa where u.id =: id")
    void update(Long id, String name, String surname, Double gpa);



}
