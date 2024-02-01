package edu.school21;

import edu.school21.entity.User;
import edu.school21.repository.UserRepository;
import edu.school21.repository.UserRepositoryJdbcTemplateImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserRepository userRepository = context.getBean("userRepositoryJdbc", UserRepository.class);
  //      User user = new User();
  //      user.setEmail("maga@gamil.com");
  //      userRepository.save(user);
        System.out.println(userRepository.findAll());
        User user = (User) userRepository.findByID(3).get();
        userRepository.delete(user.getId());
        System.out.println(userRepository.findAll());

//        System.out.println(userRepository.findByEmail("aaa@mail.ru"));
//        System.out.println(userRepository.findByEmail("bbb@mail.ru"));
//        userRepository.delete(0);
//        System.out.println(userRepository.findAll());

    }
}
