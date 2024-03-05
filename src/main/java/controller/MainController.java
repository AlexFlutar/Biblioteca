package controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import repository.entity.EntityBook;
import repository.entity.EntityPerson;
import service.BookService;
import service.impl.BookServiceImpl;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(EntityBook.class)
                .addAnnotatedClass(EntityPerson.class)
                .buildSessionFactory();

//        Scanner scanner = new Scanner(System.in);
//
//        String title = scanner.next();
//        String author = scanner.next();
//        String genre = scanner.next();
//        BookService bookService = new BookServiceImpl();
//
//        bookService.save(new EntityBook(title, author, genre));
    }
}
