package com.crud.SpringCRUD.service;

import com.crud.SpringCRUD.entity.Book;
import com.crud.SpringCRUD.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
@Autowired
private BookRepository repository;
public List<Book> findAllBooks(){
   Iterable<Book> allBooks = repository.findAll();
   return (List<Book>) allBooks;
}
public Book findBookById(Integer id){
    Optional<Book> bookById = repository.findById(id);
    if(bookById.isPresent()) {
        return bookById.get();
    }
    return new Book();
}
public Book addBook(Book book){
    return repository.save(book);
}
public Book updateBook(Book book){
    Optional<Book> result = repository.findById(book.getId());
    Book existing = result.get();
    existing.setAuthor(book.getAuthor());
    existing.setName(book.getName());
    existing.setPublication(book.getPublication());
    existing.setNumOfPages(book.getNumOfPages());
    return repository.save(existing);
}
public  void deleteById(Integer id){
    repository.deleteById(id);
}
}
