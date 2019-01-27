package br.com.vvezani.springbootgraphqlsample.controller.graphql;

import br.com.vvezani.springbootgraphqlsample.model.Book;
import br.com.vvezani.springbootgraphqlsample.repository.BookRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class QueryResolver implements GraphQLQueryResolver {

  private BookRepository bookRepository;

  public QueryResolver(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public List<Book> books() {
    return bookRepository.findAll();
  }
}