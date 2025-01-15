package com.example.demoM.repository;

import com.example.demoM.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
    List<Role> findAllByRoleIn(List<String> roles);

}
