/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.tc.epam.task5.parser_dao.impl;

import by.tc.epam.task5.entity.Book;
import by.tc.epam.task5.entity.BooksList;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.tc.epam.task5.parser_dao.ParserDAO;
import by.tc.epam.task5.parser_dao.exception.DAOIOException;
import by.tc.epam.task5.parser_dao.exception.DAOSAXException;
import by.tc.epam.task5.parser_dao.exception.DAOXMLStreamException;
import org.xml.sax.SAXException;

/**
 *
 * @author misha
 */
public class StaXParserDAO implements ParserDAO {

    @Override
    public BooksList parse(String filePath) throws DAOIOException, DAOXMLStreamException {

        try {

            XMLInputFactory factory = XMLInputFactory.newInstance();

            FileInputStream fis = new FileInputStream(new File(filePath));

            XMLStreamReader reader = factory.createXMLStreamReader(fis);

            BooksList library = process(reader);

            return library;

        }catch (IOException e){
            throw new DAOIOException(e);
        }catch (XMLStreamException e){
            throw new DAOXMLStreamException(e);
        }

    }

    @Override
    public int getMaxPage(String filePath, int countBooksOnPage)
            throws DAOIOException, DAOXMLStreamException{

        BooksList library = parse(filePath);


        int maxPage = library.getLength() / countBooksOnPage;
        if(library.getLength() % countBooksOnPage == 0){
            maxPage--;
        }
        return maxPage;
    }


    private static BooksList process(XMLStreamReader reader)
            throws XMLStreamException {

        BooksList menu = new BooksList();
        Book book = null;
        BookTagName elementName = null;

        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    
                    elementName = BookTagName.valueOf(reader.getLocalName().toUpperCase());
                    
                    switch (elementName) {
                        case BOOK:
                            book = new Book();
                            break;
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();
                    if (text.isEmpty()) {
                        break;
                    }
                    switch (elementName) {
                        case AUTHOR:
                            book.setAuthor(text);
                            break;
                        case PRICE:
                            book.setPrice(Double.parseDouble(text));
                            break;
                        case DESCRIPTION:
                            book.setDescription(text);
                            break;
                        case GENRE:
                            book.setGenre(text);
                            break;
                        case PUBLISH_DATE:
                            book.setDate(text);
                            break;
                        case TITLE:
                            book.setTitle(text);
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    
                    elementName = BookTagName.valueOf(reader.getLocalName().toUpperCase());
                           
                    switch (elementName) {
                        case BOOK:
                            menu.addBook(book);
                    }
            }
        }
        return menu;
    }

    
}

