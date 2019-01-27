package br.com.vvezani.springbootgraphqlsample.repository;

import br.com.vvezani.springbootgraphqlsample.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
