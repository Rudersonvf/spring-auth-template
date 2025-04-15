package br.com.ruderson.spring_auth_template.repository;

import br.com.ruderson.spring_auth_template.dto.UserDetailsDTO;
import br.com.ruderson.spring_auth_template.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);

    @Query(nativeQuery = true, value =
            "SELECT tb_user.email AS username, tb_user.password, tb_role.id AS roleId, tb_role.authority " +
                    "FROM tb_user " +
                    "INNER JOIN tb_user_role ON tb_user.id = tb_user_role.user_id " +
                    "INNER JOIN tb_role ON tb_role.id = tb_user_role.role_id " +
                    "WHERE tb_user.email = :emailParam")
    List<UserDetailsDTO> searchUserAndRolesByEmail(@Param("emailParam") String email);

}
