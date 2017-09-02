package controllers;

import models.User;
import play.data.validation.Valid;
import play.data.validation.Validation;
import play.mvc.Before;
import play.mvc.Controller;

public class Application extends Controller {

    // Actions with person
    //-----------------------------------------

    @Before


    //-----------------------------------------

    public static void index() {
        render();
    }

    public static void profileUser(Long id) {
        User user = User.findById(id);
        render(user);
    }

    public static void registration() {
        render();
    }

    public static void admin() {
        render();
    }

    //-----------------------------------------

    public static void auth(String username, String password) {
        User user = User.findByUsername(username);
        if (user == null || !user.checkPass(password)) {
            flash.put("username", username);
            flash.error("Bad username or password");
            render("@index");
        } else {
            session.put("id", user.id);
            session.put("username", user.username);
            flash.success("Welcome %s !", username);
            Actions.TableBooks();
        }
    }

    public static void saveUser(@Valid User user, String ConfPass) {
        validation.required(ConfPass).message("Обязательное поле*");
        validation.required(user.hashpassword).message("Обязательное поле*");
        validation.equals(ConfPass, user.hashpassword).message("Пароль должен быть более 4 и менее 20 символов");
        if (Validation.hasErrors()) {
            render("@registration", user, ConfPass);
        }
        user.save();
        session.put("id", user.id);
        session.put("user", user.username);
        session.put("password", user.hashpassword);
        flash.success("Добро пожаловать %s !", user.fullname);
        Actions.TableBooks();
    }

    public static void logout() {
        flash.success("Вы успешно вышли!");
        session.clear();
        index();
    }
}