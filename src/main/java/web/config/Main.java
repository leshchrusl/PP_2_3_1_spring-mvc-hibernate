package web.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.models.User;
import web.service.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(JPAConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user = new User("Ruslan", "Leshchinsky", 27);

        userService.createUser(user);
    }
}
