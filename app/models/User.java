package models;

/* Created by Dmitry on 21.08.2017. */

import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Users")
public class User extends Model {

    @Required(message = "Обязательное поле*")
    @MinSize(value = 4, message = "Слишком короткий логин")
    public String username;

    @Required(message = "Обязательное поле*")
    @MinSize(value = 4, message = "Слишком короткое имя пользователя")
    public String fullname;

    @Required(message = "Обязательное поле*")
    @MaxSize(20)
    @MinSize(value = 4, message = "Слишком короткий пароль")
    public String hashpassword;

    public User(String username, String hashpassword, String fullname) {
        this.username = username;
        this.hashpassword = hashpassword;
        this.fullname = fullname;
        save();
    }

    // -----------------------------------------------------------------

    public boolean checkPass(String password) {
        return hashpassword.equals(password);
    }

//    public boolean isAdmin() {
//        return username.equals(Play.configuration.getProperty("admin"));
//    }

    // -----------------------------------------------------------------

    public static User findByUsername(String username) {
        return find("username", username).first();
    }

    public static List<User> findAll(int page, int pageSize) {
        return User.all().fetch(page, pageSize);
    }

    public static boolean isUsernameAvailible(String username) {
        return findByUsername(username) == null;
    }

}
