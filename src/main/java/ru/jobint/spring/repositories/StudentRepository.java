package ru.jobint.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jobint.spring.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
