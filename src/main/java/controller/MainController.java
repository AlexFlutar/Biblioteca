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


        PersonService personService = new PersonServiceImpl();
        BookService bookService = new BookServiceImpl();



        boolean retry = false;
        do {
            System.out.println("Please insert personal number: ");
            String cnp = scanner.next();
            System.out.println("Please insert first name: ");
            String firstName = scanner.next();
            System.out.println("Please insert last name: ");
            String lastName = scanner.next();
            EntityPerson entityPerson = new EntityPerson(cnp, firstName, lastName);
            try {
                personService.save(entityPerson);
                break;
            } catch (IncorrectCnpException e) {
                    retry = true;
                System.out.println("Invalid cnp! Please retry!");
            }
        } while (retry);


        List<EntityBook> bookList = new ArrayList<>();

        addBooks(bookService, bookList);


        System.out.println("Books available: ");

//        System.out.println(bookService.findAll());
        int j = 1;
        for (EntityBook book : bookList) {
            System.out.println(bookService.findById(j));
            j++;
        }

        boolean addBooks = true;
        while (addBooks) {
            System.out.println("Do you wish to add more books to the database? Please answer with yes or no.");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("yes")) {
                System.out.println("Please insert the title of the book!");
                String title = scanner.next();
                System.out.println("Please insert the author of the book!");
                String author = scanner.next();
                System.out.println("Please insert the genre of the book!");
                String genre = scanner.next();
                bookService.save(new EntityBook(title, author, genre));
                bookList.add(new EntityBook(title, author, genre));
            }
            else
                break;

        }
        System.out.println("Books available: ");

//        System.out.println(bookService.findAll());
        int index = 1;
        for (EntityBook book : bookList) {
            System.out.println(bookService.findById(index));
            index++;
        }

        int i = 0;
        boolean chooseBooks = true;
        while (chooseBooks) {
            System.out.println("Choose books to borrow by id! ");
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
        bookService.save(new EntityBook("Harry Potter", "J. K. Rowling", "Fantasy"));
        bookList.add(new EntityBook("Harry Potter", "J. K. Rowling", "Fantasy"));
        bookService.save(new EntityBook("White Fang", "Jack London", "Adventure fiction"));
        bookList.add(new EntityBook("White Fang", "Jack London", "Adventure fiction"));
        bookService.save(new EntityBook("All souls", "Michael Patrick MacDonald", "Biographical Fiction"));
        bookList.add(new EntityBook("All souls", "Michael Patrick MacDonald", "Biographical Fiction"));
        bookService.save(new EntityBook("Dune", "Frank Herbert", "Science Fiction"));
        bookList.add(new EntityBook("Dune", "Frank Herbert", "Science Fiction"));
        bookService.save(new EntityBook("Lord of The Rings", "J. R. R. Tolkien", "Fantasy"));
        bookList.add(new EntityBook("Lord of The Rings", "J. R. R. Tolkien", "Fantasy"));
    }


}


