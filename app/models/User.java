package models;

/* Created by Dmitry on 21.08.2017. */

import play.data.validation.Match;
import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User extends Model {

    @Required(message = "Обязательное поле!")
    @MaxSize(value = 20, message = "email должен быть не больше 20 символов!")
    @MinSize(value = 4, message = "email должен быть не больше 20 символов!")
    @Match(value = "^\\w*$", message = "email должен быть больше 5 символов!")
    public String email;

    @Required(message = "Обязательное поле!")
    @MaxSize(value = 15, message = "Пароль должен быть не больше 15 символов!")
    @MinSize(value = 5, message = "Пароль должен быть больше 5 символов!")
    public String password;

    @Required(message = "Обязательное поле!")
    @MaxSize(value = 40, message = "Не более 40 символов!")
    @MinSize(value = 4, message = "не менее 4 символов!")
    public String fullname;

    public User(String email, String password, String fullname) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
    }

    public static User connect(String email, String password) {
        return find("byEmailAndPassword", email, password).first();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String value) {
        this.email = value;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String value) {
        this.password = value;
    }

    public String setAdmin(String fullname, String password) {
        if (fullname == "admin" && password == "admin") return "администратор";
        else {
            return "пользователь";
        }
    }

    public String toString() {
        return "Пользователь (" + fullname + ")";
    }

}
