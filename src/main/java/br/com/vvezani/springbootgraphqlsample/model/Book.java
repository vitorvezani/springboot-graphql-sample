package br.com.vvezani.springbootgraphqlsample.model;

import javax.persistence.*;

@Entity
public class Book {

  enum Status {
    ACTIVE, DISABLED
  }

  public Book() {
  }

  public Book(String name, Author author) {
    this.name = name;
    this.author = author;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToOne
  private Author author;

  private Status status = Status.ACTIVE;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}