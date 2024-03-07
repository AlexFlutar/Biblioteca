package controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import repository.entity.EntityBook;
import repository.entity.EntityPerson;
import service.BookService;
import service.PersonService;
import service.impl.BookServiceImpl;
import service.impl.PersonServiceImpl;

import java.util.ArrayList;
import java.util.List;
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

        EntityPerson entityPerson = new EntityPerson(cnp, firstName, lastName);
        personService.save(entityPerson);

        List<EntityBook> bookList = new ArrayList<>();

        addBooks(bookService, bookList);


        System.out.println("Books available: ");

//        System.out.println(bookService.findAll());
        int j = 1;
        for (EntityBook book : bookList) {
            System.out.println(bookService.findById(j));
            j++;
        }


        int i = 0;
        boolean chooseBooks = true;
        while (chooseBooks) {
            System.out.println("Choose books by id! ");
            i++;
            int id = scanner.nextInt();
            System.out.println("Book you borrowed is: " + bookService.findById(id));
            System.out.println("Continue? Please answer with yes or no.");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("yes"))
                chooseBooks = true;
            else
                chooseBooks = false;
            if (i == 5) {
                System.out.println("No more books available!");
                break;
            }
        }
    }


    private static void addBooks(BookService bookService, List<EntityBook> bookList) {
        bookService.save(new EntityBook("Harry Potter", "J. K. Rowling", "Fantasy", true));
        bookList.add(new EntityBook("Harry Potter", "J. K. Rowling", "Fantasy", true));
        bookService.save(new EntityBook("White Fang", "Jack London", "Adventure fiction", true));
        bookList.add(new EntityBook("White Fang", "Jack London", "Adventure fiction", true));
        bookService.save(new EntityBook("All souls", "Michael Patrick MacDonald", "Biographical Fiction", true));
        bookList.add(new EntityBook("All souls", "Michael Patrick MacDonald", "Biographical Fiction", true));
        bookService.save(new EntityBook("Dune", "Frank Herbert", "Science Fiction", true));
        bookList.add(new EntityBook("Dune", "Frank Herbert", "Science Fiction", true));
        bookService.save(new EntityBook("Lord of The Rings", "J. R. R. Tolkien", "Fantasy", true));
        bookList.add(new EntityBook("Lord of The Rings", "J. R. R. Tolkien", "Fantasy", true));
    }


}


