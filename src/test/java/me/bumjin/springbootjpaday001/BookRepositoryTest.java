package me.bumjin.springbootjpaday001;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner .class )
@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;

    @Test
    public void testFindByIsbn() {
        Book book = new Book();
        book.setIsbn("123");
        book.setName("spring jpa");

        Optional<Book> book123 = bookRepository.findByIsbn("123");
        Assertions.assertThat(book123).isEmpty();

        Book savedBook  = bookRepository.save(book);
        Assertions.assertThat(savedBook.getId()).isNotNull();

        Assertions.assertThat(bookRepository.findByIsbn("123")).isNotEmpty();


    }
}
