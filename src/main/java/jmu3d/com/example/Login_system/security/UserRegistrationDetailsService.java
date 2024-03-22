package jmu3d.com.example.Login_system.security;
/*JMU3D
UserRegistrationDetailsService
Implements Spring Security's UserDetailsService,
used by Spring Security to load user-specific data during authentication.
-Jibreel Utley
 */
import jmu3d.com.example.Login_system.user.User;
import jmu3d.com.example.Login_system.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

@Service
public class UserRegistrationDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        // Assuming roles are stored as a comma-separated list in your User entity.
        // This can be adjusted based on how roles are managed in your application.
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.isEnabled(),
                true, true, true,
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole())));
    }
}
