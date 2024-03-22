/*JMU3D
UserRegistrationSecurityConfig
Configures Spring Security for the application, 
setting up rules for request authorization, 
configuring password encoding, and defining security filter chains.
-Jibreel Utley
*/
package jmu3d.com.example.Login_system.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class UserRegistrationSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .authorizeRequests()
                .requestMatchers("/register/**").permitAll() // Allow registration for everyone
                .and()
                .authorizeRequests()
                .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN") // Restrict to admins
                .and()
                .authorizeRequests()
                .requestMatchers("/users/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN") // Restrict to logged-in users and admins
                .and()
                .formLogin()
                .and()
                .httpBasic(); // or configure a custom login process

        return http.build();
    }
}

