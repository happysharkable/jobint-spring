package ru.jobint.spring.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jobint.spring.entities.Student;
import ru.jobint.spring.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public List<Student> findAll() {
        return repository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void save(Student student) {
        repository.save(student);
    }

    public void create(Student student) {
        save(student);
    }
}
