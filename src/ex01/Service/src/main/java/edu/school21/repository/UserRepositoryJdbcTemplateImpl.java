package edu.school21.repository;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class UserRepositoryJdbcTemplateImpl implements UserRepository<User> {

    private final JdbcTemplate jdbcTemplate;


    public UserRepositoryJdbcTemplateImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jdbcTemplate.query("SELECT * FROM users WHERE email = ?", (rs, rowNumber) -> {
            User user = new User();
            user.setId(rs.getInt(1));
            user.setEmail(rs.getString(2));
            return user;
        }, email).stream().findAny();
    }

    @Override
    public Optional<User> findByID(Integer id) {
        return jdbcTemplate.query("SELECT * FROM users WHERE id = ?",
                (rs, numRow) -> {
                    User user = new User();
                    user.setId(rs.getInt(1));
                    user.setEmail(rs.getString(2));
                    return user;
                }, id).stream().findAny();
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users", (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt(1));
            user.setEmail(rs.getString(2));
            return user;
        });
    }

    @Override
    public void save(User entity) {
        jdbcTemplate.update("INSERT INTO users(email) VALUES (?)",
                entity.getEmail());
    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update("UPDATE users SET email = ? WHERE id = ?",
                entity.getEmail(), entity.getId());
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);

    }

}
