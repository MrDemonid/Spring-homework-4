package mr.demonid.hw4.controller;

import lombok.extern.java.Log;
import mr.demonid.hw4.domain.User;
import mr.demonid.hw4.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
@Log
public class UserController {

    @Autowired
    IService service;

    /**
     * Выводит список пользователей и доступных действий.
     */
    @GetMapping
    public String showUsers(Model model) {
        model.addAttribute("users", service.getUsers());
        return "users";
    }

    /**
     * Переход на форму создания пользователя.
     * @param user Передаваемый в форму объект.
     * @return
     */
    @GetMapping("/create")
    public String showCreateForm(User user) {
        return "create";
    }

    /**
     * Добавление нового пользователя в БД.
     * @return Переходит на главную страницу
     */
    @PostMapping
    public String createUser(@ModelAttribute User user) {
        log.info(user.toString());
        service.createUser(user);
        return "redirect:/users";
    }

    /**
     * Переход на форму редактирования данных пользователя.
     * @param id    Идентификатор пользователя.
     */
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        model.addAttribute("user", service.getUser(id));
        return "update";
    }

    /**
     * Обновление данных пользователя.
     * @return Редирект на главную страницу.
     */
    @PutMapping
    public String updateUser(@ModelAttribute("user") User user) {
        service.updateUser(user);
        return "redirect:/users";
    }

    /**
     * Удаление пользователя.
     * @param id Идентификатор пользователя.
     * @return Редирект на главную страницу.
     */
    @DeleteMapping("/{id}")
    public String deleteUser(Model model, @PathVariable(value = "id") int id)
    {
        service.deleteUser(id);
        return "redirect:/users";
    }
}
