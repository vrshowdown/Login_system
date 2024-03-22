package jmu3d.com.example.Login_system.user;
/*
 * JMU3D
 * UserController.java
    A REST controller that handles requests to retrieve user information. 
    It implements role-based access control to ensure that only admins can see all user data, 
    while regular users can only see their own data.
    -Jibreel Utley
 */
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getUsers() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        // Optionally, you can use PreAuthorize at the method level to restrict access
        // @PreAuthorize("hasRole('ADMIN')") // Uncomment this if you prefer method level security

        // Check if the authenticated user has the ADMIN authority
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        if (isAdmin) {
            // If the user is an admin, return all users
            return userService.getUsers();
        } else {
            // If the user is not an admin, return only the user's own data
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return userService.findByEmail(userDetails.getUsername())
                    .map(Collections::singletonList)
                    .orElse(Collections.emptyList());
        }
    }
}
