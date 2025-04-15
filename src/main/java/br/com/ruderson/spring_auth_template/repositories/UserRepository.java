package br.com.ruderson.spring_auth_template.repositories;

import br.com.ruderson.spring_auth_template.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
