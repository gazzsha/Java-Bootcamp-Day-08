package edu.school21;

import edu.school21.entity.User;
import edu.school21.repository.UserRepository;
import edu.school21.repository.UserRepositoryJdbcTemplateImpl;
import edu.school21.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
@Component
@ComponentScan("edu.school21")
public class App 
{
    public static void main( String[] args ) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        UserServiceImpl userServiceImpl =  context.getBean("userServiceImpl", UserServiceImpl.class);
        System.out.println(userServiceImpl.SignUp("aaa@mail.ru"));
  //      User user = new User();
  //      user.setEmail("maga@gamil.com");
  //      userRepository.save(user);
//System.out.println(userRepository.findAll());
  //      User user = (User) userRepository.findByID(1).get();
       // userRepository.delete(user.getId());
//        System.out.println(userRepository.findAll());

//        System.out.println(userRepository.findByEmail("aaa@mail.ru"));
//        System.out.println(userRepository.findByEmail("bbb@mail.ru"));
//        userRepository.delete(0);
//        System.out.println(userRepository.findAll());

    }
}
