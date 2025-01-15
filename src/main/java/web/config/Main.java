//package web.config;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import web.models.User;
//import web.service.UserService;
//
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(JPAConfig.class);
//
//        UserService userService = context.getBean(UserService.class);

//        User user1 = new User("Ruslan", "Leshchinsky", 27);
//        User user2 = new User("Nikolay", "Stolipin", 40);
//        User user3 = new User("Ivan", "Pshichenko", 35);
//        User user4 = new User("Andrey", "Haritonov", 27);
//        User user5 = new User("Dmitry", "Sokolov", 27);
//        User user6 = new User("Alexandr", "Jirnov", 27);

//        user6.setId(1);

//        userService.createUser(user1);
//        userService.createUser(user2);
//        userService.createUser(user3);
//        userService.createUser(user4);
//        userService.createUser(user5);

//        List<User> users = userService.getAllUsers();
//
//        for (User user : users) {
//            System.out.println(user);
//        }

//        System.out.println(userService.getUserById(3));

//        userService.updateUser(user6);

//        userService.deleteUserById(7);

//    }
//}
