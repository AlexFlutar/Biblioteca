package controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import repository.entity.EntityBook;
import repository.entity.EntityPerson;
import service.BookService;
import service.PersonService;
import service.impl.BookServiceImpl;
import service.impl.PersonServiceImpl;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Please insert personal number: ");
        String cnp = scanner.next();
        System.out.println("Please insert first name: ");
        String firstName = scanner.next();
        System.out.println("Please insert last name: ");
        String lastName = scanner.next();
        PersonService personService = new PersonServiceImpl();
        BookService bookService = new BookServiceImpl();

        EntityBook entityBook = new EntityBook("Harry Potter", "J. K. Rowling", "Fantasy");
        entityBook.setPerson(new EntityPerson(15, cnp, firstName, lastName));

        personService.save(new EntityPerson(cnp, firstName, lastName));

        bookService.save(entityBook);
        bookService.save(new EntityBook("White Fang", "Jack London", "Adventure fiction"));
        bookService.save(new EntityBook("All souls", "Michael Patrick MacDonald", "Biographical Fiction"));
        bookService.save(new EntityBook("Dune", "Frank Herbert", "Science Fiction"));
        bookService.save(new EntityBook("Lord of The Rings", "J. R. R. Tolkien", "Fantasy"));

        System.out.println("Books available: ");

        System.out.println(bookService.findAll());
        System.out.println(bookService.findById(1));




    }
}
