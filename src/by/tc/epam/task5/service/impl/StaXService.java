/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.tc.epam.task5.service.impl;

import by.tc.epam.task5.entity.BooksList;
import java.io.IOException;
import javax.xml.stream.XMLStreamException;

import by.tc.epam.task5.parser_dao.DAOFactory;
import by.tc.epam.task5.parser_dao.exception.DAOIOException;
import by.tc.epam.task5.parser_dao.exception.DAOXMLStreamException;
import by.tc.epam.task5.parser_dao.impl.StaXParserDAO;
import by.tc.epam.task5.service.ParserService;
import by.tc.epam.task5.service.exception.ServiceIOException;
import by.tc.epam.task5.service.exception.ServiceXMLStreamException;

/**
 *
 * @author misha
 */
public class StaXService implements ParserService {
    
    private final DAOFactory factory = DAOFactory.getInstance();
    private final StaXParserDAO staxParser = factory.getStaXParser();

    @Override
    public BooksList parse(String filePath, int page, int countBooksOnPage)
            throws ServiceIOException, ServiceXMLStreamException {

        try{

            return staxParser.parse(filePath).subList(page, countBooksOnPage);

        }catch (DAOIOException e){
            throw new ServiceIOException(e);
        }catch (DAOXMLStreamException e){
            throw new ServiceXMLStreamException(e);
        }
    }

    @Override
    public int getMaxPage(String filePath, int countBooksOnPage)
            throws ServiceIOException, ServiceXMLStreamException {

        try {

            return staxParser.getMaxPage(filePath, countBooksOnPage);

        }catch (DAOIOException e){
            throw new ServiceIOException(e);
        }catch (DAOXMLStreamException e){
            throw new ServiceXMLStreamException(e);
        }
    }
    
}
