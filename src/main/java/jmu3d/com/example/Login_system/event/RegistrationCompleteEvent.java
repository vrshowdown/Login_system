package jmu3d.com.example.Login_system.event;
/*JMU3D
RegistrationCompleteEvent
A custom application event class that gets published when a new user registration is completed. 
It contains information about the registered user and the application URL.
-Jibreel
*/
import jmu3d.com.example.Login_system.user.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {
    private User user;
    private String applicationUrl;
    public RegistrationCompleteEvent( User user, String applicationUrl){
        super(user);
        this.user = user;
        this.applicationUrl = applicationUrl;
    }

}
