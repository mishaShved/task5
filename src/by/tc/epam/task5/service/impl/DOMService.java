/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.tc.epam.task5.service.impl;

import by.tc.epam.task5.entity.BooksList;
import java.io.IOException;

import by.tc.epam.task5.parser_dao.exception.DAOIOException;
import by.tc.epam.task5.parser_dao.exception.DAOSAXException;
import by.tc.epam.task5.service.exception.ServiceIOException;
import by.tc.epam.task5.service.exception.ServiceSAXException;
import org.xml.sax.SAXException;
import by.tc.epam.task5.parser_dao.DAOFactory;
import by.tc.epam.task5.parser_dao.impl.DOMParserDAO;
import by.tc.epam.task5.service.ParserService;

/**
 *
 * @author misha
 */
public class DOMService implements ParserService {
    
    private final DAOFactory factory = DAOFactory.getInstance();
    private final DOMParserDAO domParser = factory.getDOMParser();

    @Override
    public BooksList parse(String filePath, int page, int countBooksOnPage)
            throws ServiceIOException, ServiceSAXException {

        try{

            return domParser.parse(filePath).subList(page, countBooksOnPage);

        }catch (DAOIOException e){
            throw new ServiceIOException(e);
        }catch (DAOSAXException e){
            throw new ServiceSAXException(e);
        }

    }
    
    @Override
    public int getMaxPage(String filePath, int countBooksOnPage)
            throws ServiceIOException, ServiceSAXException {

        try {

            return domParser.getMaxPage(filePath, countBooksOnPage);

        }catch (DAOIOException e) {
            throw new ServiceIOException(e);
        }catch (DAOSAXException e) {
            throw new ServiceSAXException(e);
        }

    }
    
}
