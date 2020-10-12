package kz.iitu.authservice.repository;

import kz.iitu.authservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    public Role findByRole(String role);
}
