package sda.onetomanybookstore;

import javax.persistence.*;
import java.util.Optional;

public class AuthorManager {

    private EntityManager manager;

    public void addAuthor(Author author){
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(author);
        transaction.commit();
    }

    // change url in persistance.xml (standard port is 3306)
    public AuthorManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
        manager = factory.createEntityManager();
    }

    public void addBookToExistingAuthor(BookOfAuthor book, long id){

    }

    public Optional<Author> findAnyAuthor() {
        Author result = manager.createQuery("SELECT onetomanybookstore FROM Author onetomanybookstore", Author.class).getSingleResult();
        return Optional.ofNullable(result);
    }

    public Optional<Author> findBySurname(String surname){
        TypedQuery<Author> query = manager.createQuery("SELECT onetomanybookstore FROM Author onetomanybookstore WHERE onetomanybookstore.surname=:surname", Author.class);
        query.setParameter("surname", surname);
        return Optional.ofNullable(query.getSingleResult());
    }

}