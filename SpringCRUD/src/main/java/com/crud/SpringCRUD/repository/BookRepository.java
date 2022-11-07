package com.crud.SpringCRUD.repository;

import com.crud.SpringCRUD.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {



}
