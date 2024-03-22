/*JMU3D
VerificationTokenRepository
A Spring Data JPA repository interface for VerificationToken entities, 
providing CRUD operations and a method to find a token by its string value.
-Jibreel Utley
*/
package jmu3d.com.example.Login_system.registration.token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    VerificationToken findByToken(String token);
}
