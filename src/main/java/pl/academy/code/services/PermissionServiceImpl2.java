package pl.academy.code.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Primary
public class PermissionServiceImpl2 implements PermissionsService {
    public String resolvePermissions() {
        Random r = new Random();
        if(r.nextBoolean()) {
            return "SUPER-ALL";
        } else {
            return "SUPER-SPECIFIC";
        }
    }
}
