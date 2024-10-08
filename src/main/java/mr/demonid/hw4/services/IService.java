package mr.demonid.hw4.services;

import mr.demonid.hw4.domain.User;

import java.util.List;

public interface IService {

    /**
     * Возвращает список всех пользователей
     */
    List<User> getUsers();

    /**
     * Возвращает пользователя.
     * @param id Идентификатор пользователя.
     */
    User getUser(int id);

    /**
     * Создание нового пользователя.
     * @param user Структура пользователя. ID должен быть NULL!
     */
    User createUser(User user);

    /**
     * Обновление данных о пользователе.
     * @param user Обновленные данные.
     */
    User updateUser(User user);

    /**
     * Удаление пользователя.
     * @param id Идентификатор пользователя.
     */
    void deleteUser(int id);

}
