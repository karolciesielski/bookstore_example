package sda.onetomanybookstore;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class AuthorManagerTest {
    @DisplayName("add an onetomanybookstore to the database and check if it exists")
    @Test
    public void addAuthorTest(){
        //given
        Author author = new Author("Trudi", "Canavan");
        AuthorManager manager = new AuthorManager();
        manager.addAuthor(author);

        //when
        Optional<Author> foundAuthor = manager.findAnyAuthor();

        //then
        Assertions.assertThat(foundAuthor).hasValue(author);
    }

    @DisplayName("add two authors and find one of them by surname")
    @Test
    public void findAuthorTest(){
        //given
        Author author = new Author("Trudi", "Canavan");
        Author author2 = new Author("Adam", "Mickiewicz");
        AuthorManager manager = new AuthorManager();
        manager.addAuthor(author);
        manager.addAuthor(author2);

        //when
        Optional<Author> result = manager.findBySurname("Mickiewicz");

        //then
        Assertions.assertThat(result.get().getSurname()).isEqualTo("Mickiewicz");

    }
}