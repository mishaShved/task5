/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.tc.epam.task5.parser_dao.impl;

import by.tc.epam.task5.entity.Book;
import by.tc.epam.task5.entity.BooksList;
import java.io.IOException;

import by.tc.epam.task5.parser_dao.exception.DAOIOException;
import by.tc.epam.task5.parser_dao.exception.DAOSAXException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import by.tc.epam.task5.parser_dao.ParserDAO;

/**
 *
 * @author misha
 */
public class SAXParserDAO implements ParserDAO {

    @Override
    public BooksList parse(String filePath) throws DAOSAXException, DAOIOException {
        try {
            BooksList library = new BooksList();
            XMLReader reader = XMLReaderFactory.createXMLReader();

            reader.setContentHandler(new LibrarySAXHandler(library));

            reader.parse(filePath);

            return library;
        }catch (SAXException e){
            throw new DAOSAXException(e);
        }catch (IOException e){
            throw new DAOIOException(e);
        }
    }

    @Override
    public int getMaxPage(String filePath, int countBooksOnPage) throws DAOSAXException, DAOIOException{
        BooksList library = parse(filePath);


        int maxPage = library.getLength() / countBooksOnPage;
        if(library.getLength() % countBooksOnPage == 0){
            maxPage--;
        }

        return maxPage;
    }

}

class LibrarySAXHandler extends DefaultHandler {

        private final BooksList library;
        private Book book;
        private StringBuilder text;

        public LibrarySAXHandler() {
            library = new BooksList();
        }

        public LibrarySAXHandler(BooksList library) {
            this.library = library;
        }      

        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {

            text = new StringBuilder();
            if (qName.equals("book")) {
                book = new Book();
            }
        }

        @Override
        public void characters(char[] buffer, int start, int length) {
            text.append(buffer, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            BookTagName tagName = BookTagName.valueOf(qName.toUpperCase());
            switch (tagName) {
                case AUTHOR:
                    book.setAuthor(text.toString());
                    break;
                case PRICE:
                    book.setPrice(Double.parseDouble(text.toString()));
                    break;
                case DESCRIPTION:
                    book.setDescription(text.toString());
                    break;
                case GENRE:
                    book.setGenre(text.toString());
                    break;
                case PUBLISH_DATE:
                    book.setDate(text.toString());
                    break;
                case TITLE:
                    book.setTitle(text.toString());
                    break;
                case BOOK:
                    library.addBook(book);
                    book = null;
                    break;
            }
        }
}
