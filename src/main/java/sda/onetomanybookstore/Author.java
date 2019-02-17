package sda.onetomanybookstore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "onetomanybookstore")

public class Author {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String surname;

    @OneToMany
    private Collection<BookOfAuthor> books;

    public Author() {}

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "onetomanybookstore{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getSurname() {
        return surname;
    }
}