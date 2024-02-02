package edu.school21.service;

import java.sql.SQLException;

public interface UserService {
    String SignUp(String email) throws SQLException;
}
