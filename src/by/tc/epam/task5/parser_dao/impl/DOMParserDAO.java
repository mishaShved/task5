package by.tc.epam.task5.parser_dao.impl;


import by.tc.epam.task5.parser_dao.exception.DAOIOException;
import by.tc.epam.task5.parser_dao.exception.DAOSAXException;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import by.tc.epam.task5.entity.Book;
import by.tc.epam.task5.entity.BooksList;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import by.tc.epam.task5.parser_dao.ParserDAO;


public class DOMParserDAO implements ParserDAO {

    @Override
    public BooksList parse(String filePath) throws DAOIOException, DAOSAXException {

        try {
            DOMParser parser = new DOMParser();
            parser.parse(filePath);

            Document document = parser.getDocument();
            Element root = document.getDocumentElement();

            BooksList library = new BooksList();

            NodeList bookNodes = root.getElementsByTagName("book");

            Book book = null;
            for (int i = 0; i < bookNodes.getLength(); i++) {
                book = new Book();
                Element bookElement = (Element) bookNodes.item(i);

                book.setDescription(getSingleChild(bookElement,
                        "description").getTextContent().trim());

                book.setAuthor(getSingleChild(bookElement,
                        "author").getTextContent().trim());
                book.setDate(getSingleChild(bookElement,
                        "publish_date").getTextContent().trim());
                book.setGenre(getSingleChild(bookElement,
                        "genre").getTextContent().trim());
                book.setPrice(Double.parseDouble(getSingleChild(bookElement,
                        "price").getTextContent().trim()));
                book.setTitle(getSingleChild(bookElement,
                        "title").getTextContent().trim());

                library.addBook(book);
            }

            return library;
        }catch (IOException e){
            throw new DAOIOException(e);
        }catch (SAXException e){
            throw new DAOSAXException(e);
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

    private static Element getSingleChild(Element element, String childName) {
        NodeList nlist = element.getElementsByTagName(childName);
        Element child = (Element) nlist.item(0);
        return child;
    }

}
