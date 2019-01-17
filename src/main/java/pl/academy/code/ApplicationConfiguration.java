package pl.academy.code;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.academy.code.services.*;

@Configuration
@ComponentScan("pl.academy.code.services")
public class ApplicationConfiguration {

    /*@Bean
    public PermissionsService permissionService() {
        return new PermissionServiceImpl2();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }*/
}
