/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.tc.epam.task5.parser_dao;

import by.tc.epam.task5.entity.BooksList;

import by.tc.epam.task5.parser_dao.exception.DAOIOException;
import by.tc.epam.task5.parser_dao.exception.DAOSAXException;
import by.tc.epam.task5.parser_dao.exception.DAOXMLStreamException;


/**
 *
 * @author misha
 */
public interface ParserDAO {
    
    BooksList parse(String filePath) throws DAOIOException, DAOSAXException, DAOXMLStreamException;
    int getMaxPage(String filePath, int countBooksOnPage) throws DAOIOException, DAOSAXException, DAOXMLStreamException;
            
}
