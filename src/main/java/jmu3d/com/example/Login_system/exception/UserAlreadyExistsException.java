package jmu3d.com.example.Login_system.exception;
/*JMU3D
UserAlreadyExistsException
A custom exception class that is thrown when an attempt is made to register a user with an email address that already exists in the database.
-Jibreel Utley
*/
public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}