/*JMU3D
RegistrationRequest
A data transfer object (DTO) class used to capture registration details from the request body.
-Jibreel Utley
*/
package jmu3d.com.example.Login_system.registration;

public record RegistrationRequest(String firstName,
                                  String lastName,
                                  String email,
                                  String password,
                                  String role) {

}
