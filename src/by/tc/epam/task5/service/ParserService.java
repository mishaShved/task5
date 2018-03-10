/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.tc.epam.task5.service;

import by.tc.epam.task5.entity.BooksList;
import java.io.IOException;
import javax.xml.stream.XMLStreamException;

import by.tc.epam.task5.service.exception.ServiceIOException;
import by.tc.epam.task5.service.exception.ServiceSAXException;
import by.tc.epam.task5.service.exception.ServiceXMLStreamException;
import org.xml.sax.SAXException;


public interface ParserService {
    
    
    BooksList parse(String filePath, int page, int countBooksOnPage)
            throws ServiceIOException, ServiceSAXException, ServiceXMLStreamException;

    int getMaxPage(String filePath, int countBooksOnPage)
            throws ServiceIOException, ServiceSAXException, ServiceXMLStreamException;
    
    
}
