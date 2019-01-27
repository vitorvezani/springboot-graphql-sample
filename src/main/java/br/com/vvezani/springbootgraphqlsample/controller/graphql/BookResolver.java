package br.com.vvezani.springbootgraphqlsample.controller.graphql;

import br.com.vvezani.springbootgraphqlsample.model.Book;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLResolver<Book> {

  public String wikiInfo(Book book) {
    // TODO: Use RestTemplate to get info from external API
    return "mocked Data for book " + book.getName();
  }

}
