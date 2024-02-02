package edu.school21.service;

import edu.school21.entity.User;
import edu.school21.repository.UserRepository;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    private final UserRepository<User> userRepository;


    public UserServiceImpl(@Qualifier("userRepositoryJdbcTemplateImpl") UserRepository<User> userUserRepository) {
        userRepository = userUserRepository;
    }

    @Override
    public String SignUp(String email) throws SQLException {
            User user = new User();
            user.setEmail(email);
            RandomStringGenerator generator = new RandomStringGenerator.Builder()
                    .withinRange('a', 'z').build();
            String randomPassword = generator.generate(20);
            user.setPassword(randomPassword);
            userRepository.save(user);
            return randomPassword;
    }
}
