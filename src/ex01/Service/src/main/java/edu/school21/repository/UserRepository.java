package edu.school21.repository;

import edu.school21.entity.User;

import java.sql.SQLException;
import java.util.Optional;

public interface UserRepository<T> extends CrudRepository<T> {
    Optional<T> findByEmail(String email) throws SQLException;

}
