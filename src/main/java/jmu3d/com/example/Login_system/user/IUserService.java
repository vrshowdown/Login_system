/*JMU3D
IUserService
An interface that defines the contract for user-related operations, 
including retrieving all users, registering a new user, 
finding a user by email, saving a verification token, and validating a token.
-Jibreel Utley
*/
package jmu3d.com.example.Login_system.user;
import jmu3d.com.example.Login_system.registration.RegistrationRequest;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getUsers();
    User registerUser(RegistrationRequest request);
    Optional<User> findByEmail(String email);
    void saveUserVerificationToken(User theUser, String verificationToken);
    String validateToken(String theToken);
}
