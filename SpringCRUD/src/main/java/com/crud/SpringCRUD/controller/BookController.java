package com.crud.SpringCRUD.controller;

import com.crud.SpringCRUD.entity.Book;
import com.crud.SpringCRUD.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class BookController {
@Autowired
BookService bookService;
@GetMapping("/")
public String findAll(Model model){
model.addAttribute("books",bookService.findAllBooks());
return "all-books";
}
@GetMapping("/add")
public String lunchAddBookPage(Model model){
    model.addAttribute("book",new Book());
    return "add-book";
}
@PostMapping("/addbook")
public String createBook(Book book){
bookService.addBook(book);
return "redirect:/";
}
@GetMapping("/edit/{id}")
public String lunchEditPage(Model model,@PathVariable("id") Integer id){
        model.addAttribute("book",bookService.findBookById(id));
        return "edit-book";
}
@PostMapping("/updatebook")
public String updateBook(Book book){
bookService.updateBook(book);
return "redirect:/";
}
@GetMapping("/delete/{id}")
public String deleteBook(@PathVariable("id") Integer id){
    bookService.deleteById(id);
    return  "redirect:/";
}
@GetMapping("/test")
public  String test(){
    Book book = new Book();
    book.setId(1);
    book.setName("Land of Java");
    book.setAuthor("Vusal");
    book.setNumOfPages(1000);
    book.setPublication("UsaCanada");
    bookService.addBook(book);
    return "index";
}
}
