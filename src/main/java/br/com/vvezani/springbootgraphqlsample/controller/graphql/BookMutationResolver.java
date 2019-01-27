package br.com.vvezani.springbootgraphqlsample.controller.graphql;

import br.com.vvezani.springbootgraphqlsample.model.Book;
import br.com.vvezani.springbootgraphqlsample.repository.AuthorRepository;
import br.com.vvezani.springbootgraphqlsample.repository.BookRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class BookMutationResolver implements GraphQLMutationResolver {

  private final BookRepository bookRepository;
  private final AuthorRepository authorRepository;

  public BookMutationResolver(BookRepository bookRepository, AuthorRepository authorRepository) {
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
  }

  public Book addBook(String name, Long authorId) {
    Book bean = new Book();
    bean.setName(name);
    bean.setAuthor(authorRepository.findById(authorId).orElseThrow(() -> new IllegalArgumentException("")));
    return bookRepository.save(bean);
  }

}
