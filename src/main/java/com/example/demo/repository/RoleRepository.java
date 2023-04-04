package com.example.demo.repository;

import com.example.demo.model.ERole;
import com.example.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);

    List<Role> findRolesByNameContainingAndIdAfter(String name, int idmax);
}
