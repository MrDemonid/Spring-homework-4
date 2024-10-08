package mr.demonid.hw4.services;

import lombok.AllArgsConstructor;
import mr.demonid.hw4.domain.User;
import mr.demonid.hw4.repository.IRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements IService {

    private IRepository repository;

    @Override
    public List<User> getUsers() {
        return repository.getUsers();
    }

    @Override
    public User getUser(int id) {
        return repository.getUser(id);
    }

    @Override
    public User createUser(User user) {
        return repository.addUser(user);
    }

    @Override
    public User updateUser(User user) {
        return repository.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        repository.deleteUser(id);
    }
}
