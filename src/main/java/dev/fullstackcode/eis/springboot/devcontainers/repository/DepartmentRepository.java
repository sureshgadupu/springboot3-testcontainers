package dev.fullstackcode.eis.springboot.devcontainers.repository;


import dev.fullstackcode.eis.springboot.devcontainers.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
