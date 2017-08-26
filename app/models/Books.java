package models;

/* Created by Dmitry on 22.08.2017 */

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Books extends Model {

    public String name;
    public String author;

    public Books(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public Long getId() {
        return super.getId();
    }
}
