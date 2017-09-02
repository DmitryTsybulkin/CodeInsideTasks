package controllers;

import models.Books;
import play.mvc.Controller;

import java.util.List;

/** Created by Dmitry on 02.09.2017. */
public class Actions extends Controller {

    //---------------------------------------

    public static void TableUsers() {
        render();
    }

    public static void TableBooks() {
        List<Books> books = Books.find("byId", Application.connected()).fetch();
        render(books);
    }

    public static void readers() {
        render();
    }

    //---------------------------------------

    public static void addBook() {}

    public static void addBookUser() {}

    public static void handOver() {}

    public static void deleteBook() {}

    public static void addUser() {}

    public static void deleteUser() {}

}
