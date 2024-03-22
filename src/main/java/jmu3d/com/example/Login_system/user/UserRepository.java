/*JMU3D
UserRepository.java
A Spring Data JPA repository interface for User entities, 
providing CRUD operations and a method to find a user by email.
-Jibreel Utley
*/
package jmu3d.com.example.Login_system.user;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
