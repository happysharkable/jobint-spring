package ru.jobint.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jobint.spring.entities.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
