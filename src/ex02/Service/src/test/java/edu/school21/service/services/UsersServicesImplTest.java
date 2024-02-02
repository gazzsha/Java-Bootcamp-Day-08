package edu.school21.service.services;


import edu.school21.service.UserService;
import edu.school21.service.config.TestApplicationConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestApplicationConfig.class)
public class UsersServicesImplTest {

    @Autowired
    private UserService userService;


    @Test
    public void testSetPassword() throws SQLException {
        String password = userService.SignUp("mama@mail.ru");
        assertNotNull(password);
    }

}
