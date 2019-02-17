package sda.jdbc_jpa_bookstore;

import java.util.Collection;

public interface BookStoreManager {

    void add(String title, String author);

    Collection<Book> findAll();


}