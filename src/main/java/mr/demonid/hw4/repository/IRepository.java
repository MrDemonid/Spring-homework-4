package mr.demonid.hw4.repository;

import mr.demonid.hw4.domain.User;

import java.util.List;

public interface IRepository {

    /**
     * Получить список всех пользователей
     */
    List<User> getUsers();

    /**
     * Добавить нового пользователя
     */
    User addUser(User user);

    /**
     * Получить пользователя
     * @param id Идентификатор пользователя
     * @return null если такого пользователя нет.
     */
    User getUser(int id);

    /**
     * Удалить пользователя из БД.
     * @param id Идентификатор пользователя.
     */
    void deleteUser(int id);

    /**
     * Обновить данные о пользователе в БД.
     * @return null в случае ошибки.
     */
    User updateUser(User user);

}
