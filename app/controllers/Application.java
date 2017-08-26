package controllers;

import models.User;
import play.data.validation.Valid;
import play.mvc.Before;
import play.mvc.Controller;

public class Application extends Controller {

    // Actions

    @Before
    static void addUser() {
        User user = connected();
        if (user != null) {
            renderArgs.put("user", user);
        }
    }

    static User connected() {
        if (renderArgs.get("user") != null) {
            return renderArgs.get("user", User.class);
        }
        String username = session.get("user");
        if (username != null) {
            return User.find("byUsername", username).first();
        }
        return null;
    }

    public static void index() {
        if (connected() != null) {
            index();
        }
        render();
    }

    public static void profile() {
        render();
    }

    public static void registration() {
        render();
    }

    public static void saveUser(@Valid User user, String email, String verifyPassword) {
        validation.required(verifyPassword);
        validation.equals(verifyPassword, user.password).message("Ваш пароль некорректный!");
        if (validation.hasErrors()) {
            render("@registration", user, verifyPassword);
        }
        user.create();
        session.put("user", user.fullname);
        flash.success("Добро пожаловать, " + user.fullname);
        profile();
    }

    public static void login(String email, String password) {
        User user = User.find("byEmailAndPassword", email, password).first();
        if(user != null) {
            session.put("user", user.email);
            flash.success("Welcome, " + user.fullname);
            profile();
        }
        flash.put("email", email);
        flash.error("Login failed");
    }

    public static void logout() {
        session.clear();
        index();
    }
}