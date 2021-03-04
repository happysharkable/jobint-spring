package ru.jobint.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jobint.spring.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
