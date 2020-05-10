package stauffer.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import stauffer.springframework.spring5webapp.domain.Author;
import stauffer.springframework.spring5webapp.domain.Book;
import stauffer.springframework.spring5webapp.domain.Publisher;
import stauffer.springframework.spring5webapp.repositories.AuthorRepository;
import stauffer.springframework.spring5webapp.repositories.BookRepository;
import stauffer.springframework.spring5webapp.repositories.PublisherRepository;


/**
 * Created by jt on 12/23/19.
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        authorRepository.save(eric);
        Book ddd = new Book("Domain Driven Design", "123123");
        bookRepository.save(ddd);
        Publisher rh = new Publisher("Random House","1745 Broadway","New York","NY","10019");
        publisherRepository.save(rh);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(rh);
        rh.getBooks().add(ddd);
//        publisherRepository.save(rh);


        Author rod = new Author("Rod", "Johnson");
        authorRepository.save(rod);
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        bookRepository.save(noEJB);
        Publisher hm = new Publisher("Houghton Mifflin Harcourt","125 High Street","Boston","MA","02110");
        publisherRepository.save(hm);

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(rh);
//        publisherRepository.save(rh);
        rh.getBooks().add(noEJB);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println(rh.toString());
        System.out.println(hm.toString());
        
    }
}
