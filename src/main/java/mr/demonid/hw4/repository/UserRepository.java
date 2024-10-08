package mr.demonid.hw4.repository;

import mr.demonid.hw4.config.SqlConfig;
import mr.demonid.hw4.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
public class UserRepository implements IRepository {

    private final JdbcTemplate jdbc;
    private SqlConfig sqlRequests;                // sql-запросы из файла-конфигурации

    public UserRepository(JdbcTemplate jdbc, SqlConfig sqlRequests) {
        this.jdbc = jdbc;
        this.sqlRequests = sqlRequests;
    }

    @Override
    public List<User> getUsers() {
        return jdbc.query(sqlRequests.getGetAllUser(), (rs, rowNum) -> {
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
        jdbc.update(sqlRequests.getInsert(), user.getFirstName(), user.getLastName(), user.getSqlBirthDate(), user.getEmail());
        return user;
    }

    @Override
    public User getUser(int id) {
        return jdbc.query(sqlRequests.getGetUser(),new Object[]{id}, new int[]{Types.INTEGER}, (rs, rowNum) -> {
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
        jdbc.update(sqlRequests.getDeleteUser(), id);
    }

    @Override
    public User updateUser(User user) {
        jdbc.update(sqlRequests.getUpdateUser(), user.getFirstName(), user.getLastName(), user.getSqlBirthDate(), user.getEmail(), user.getId());
        return getUser(user.getId());
    }
}
