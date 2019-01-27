package br.com.vvezani.springbootgraphqlsample;

import br.com.vvezani.springbootgraphqlsample.model.Author;
import br.com.vvezani.springbootgraphqlsample.model.Book;
import br.com.vvezani.springbootgraphqlsample.repository.AuthorRepository;
import br.com.vvezani.springbootgraphqlsample.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringBootGraphqlSampleApplication {

  @Autowired
  private BookRepository bookRepository;
  @Autowired
  private AuthorRepository authorRepository;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootGraphqlSampleApplication.class, args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void initData() {

    Author georgeOrwell = authorRepository.save(new Author("George Orwell"));

    final Book book = new Book("1984", georgeOrwell);
    final Book book2 = new Book("Animal Farm", georgeOrwell);

    bookRepository.saveAll(Arrays.asList(book, book2));
  }

}

