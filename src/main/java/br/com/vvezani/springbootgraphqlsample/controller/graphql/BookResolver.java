package br.com.vvezani.springbootgraphqlsample.controller.graphql;

import br.com.vvezani.springbootgraphqlsample.model.Author;
import br.com.vvezani.springbootgraphqlsample.model.Book;
import br.com.vvezani.springbootgraphqlsample.repository.AuthorRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLResolver<Book> {

  private AuthorRepository authorRepository;

  public BookResolver(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  public Author author(Book book) {
    return authorRepository.findById(book.getAuthorId()).orElseGet(null);
  }
}
