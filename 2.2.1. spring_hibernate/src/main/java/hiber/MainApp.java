package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", "niva", 2000));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", "niva", 2000));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", "niva", 200));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", "bike", 2000));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }


      List<User> usersWithCar = userService.getUserByCar("niva", 2000);
      for (User user : usersWithCar) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("CarModel = " + user.getCar().getModel());
         System.out.println("CarSeries = " + user.getCar().getSeries());
         System.out.println();
      }

      context.close();
   }
}
