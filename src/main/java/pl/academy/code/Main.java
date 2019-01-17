package pl.academy.code;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.academy.code.model.User;
import pl.academy.code.services.UserService;
import pl.academy.code.services.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        DBHandler.connect();

        User user = new User();
        user.setLogin("janusz5");
        user.setPass("tajne");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        UserService userService = context.getBean(UserService.class);

        userService.saveUser(user);
        /*Scanner scanner = new Scanner(System.in);

        user.setLogin(scanner.nextLine());
        user.setPass(scanner.nextLine());*/

        //UserServiceImpl.saveUser(user);

        //System.out.println(UserServiceImpl.getUserById(1));

        //System.out.println(UserServiceImpl.authorizeUser(user));
    }
}
