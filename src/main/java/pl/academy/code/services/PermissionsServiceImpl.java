package pl.academy.code.services;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PermissionsServiceImpl implements PermissionsService {
    public String resolvePermissions() {
        Random r = new Random();
        if(r.nextBoolean()) {
            return "ALL";
        } else {
            return "SPECIFIC";
        }
    }
}
