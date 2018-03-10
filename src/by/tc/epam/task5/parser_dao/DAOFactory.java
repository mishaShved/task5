/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.tc.epam.task5.parser_dao;

import by.tc.epam.task5.parser_dao.impl.DOMParserDAO;
import by.tc.epam.task5.parser_dao.impl.SAXParserDAO;
import by.tc.epam.task5.parser_dao.impl.StaXParserDAO;

/**
 *
 * @author misha
 */
public final class DAOFactory {
    
    private static final DAOFactory instance = new DAOFactory();
    
    private final DOMParserDAO domParser = new DOMParserDAO();
    private final StaXParserDAO staxParser = new StaXParserDAO();
    private final SAXParserDAO saxParser = new SAXParserDAO();

    private DAOFactory() {
    }
    
    public static DAOFactory getInstance(){
        return instance;
    }
    
    public StaXParserDAO getStaXParser(){
        return staxParser;
    } 
    
    public DOMParserDAO getDOMParser(){
        return domParser;
    }
    
    public SAXParserDAO getSAXParser(){
        return saxParser;
    }
}
