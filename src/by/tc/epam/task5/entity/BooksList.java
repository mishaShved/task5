/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.tc.epam.task5.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author misha
 */
public class BooksList {
    
    private List<Book> books;

    public BooksList() {
        this.books = new ArrayList<>();
    }

    public BooksList(ArrayList<Book> books) {
        this.books = books;
    }

    public Book getBook(int index) {
        return books.get(index);
    }
    
    public void addBook(Book book){
        books.add(book);
    }   
    
    public int getLength(){
        return books.size();
    }
    
    public BooksList subList(int pageNumber, int countBookOnPage){
        
        BooksList res = new BooksList();
        
        for(int i = pageNumber * countBookOnPage, j = 0;
                j < countBookOnPage && j < books.size(); i++, j++){
            if(i >= books.size()){
                break;
            }
            res.addBook(books.get(i));            
        }   
        return res;        
    }
    
     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BooksList booksList = (BooksList) o;
        return Objects.equals(books, booksList.books);
    }

    @Override
    public int hashCode() {

        return Objects.hash(books);
    }

    @Override
    public String toString() {
        
        StringBuilder result = new StringBuilder();
        for(Book book : books){
            result.append(book);
        }
        return result.toString();
    }  
    
}
