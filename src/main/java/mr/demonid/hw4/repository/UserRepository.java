package mr.demonid.hw4.repository;

import mr.demonid.hw4.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
public class UserRepository implements IRepository {

    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<User> getUsers() {
        String sql = "SELECT * FROM userTable";

        return jdbc.query(sql, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setBirthDate(rs.getDate("birthDate").toLocalDate());
            user.setEmail(rs.getString("email"));
            return user;
        });
    }

    @Override
    public User addUser(User user) {
        String sql = "INSERT INTO userTable (firstName, lastName, birthDate, email) VALUES(?, ?, ?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getSqlBirthDate(), user.getEmail());
        return user;
    }

    @Override
    public User getUser(int id) {
        String sql = "SELECT * FROM userTable WHERE id=?";

        return jdbc.query(sql,new Object[]{id}, new int[]{Types.INTEGER}, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setEmail(rs.getString("email"));
            user.setSqlBirthDate(rs.getDate("birthDate"));
            return user;
        }).stream().findFirst().orElse(new User());
    }

    @Override
    public void deleteUser(int id) {
        String sql = "DELETE FROM userTable WHERE id=?";

        jdbc.update(sql, id);
    }

    @Override
    public User updateUser(User user) {
        String sql = "UPDATE userTable SET firstName=?, lastName=?, birthDate=?, email=? WHERE id=?";

        jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getSqlBirthDate(), user.getEmail(), user.getId());
        return getUser(user.getId());
    }
}
