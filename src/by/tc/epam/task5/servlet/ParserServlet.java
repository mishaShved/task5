package by.tc.epam.task5.servlet;

import by.tc.epam.task5.entity.BooksList;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tc.epam.task5.service.exception.ServiceIOException;
import by.tc.epam.task5.service.exception.ServiceSAXException;
import by.tc.epam.task5.service.exception.ServiceXMLStreamException;
import org.xml.sax.SAXException;
import by.tc.epam.task5.configuration.WorkerWithProperties;

import javax.servlet.RequestDispatcher;
import javax.xml.stream.XMLStreamException;
import by.tc.epam.task5.service.ServiceBuilder;
import by.tc.epam.task5.service.ParserService;

public class ParserServlet extends HttpServlet {

    private static final int COUNT_BOOKS_ON_PAGE = 3;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServiceBuilder builder = ServiceBuilder.getInstance();
        BooksList library = null;
        int maxPage = 0;
        String filePath = WorkerWithProperties.getOurInstance().getXMLFilePath();

        String parseType = request.getParameter("parsType");
        int page = Integer.parseInt(request.getParameter("page"));

        ParserService service = builder.getService(parseType);

        try {
            library = service.parse(filePath, page, COUNT_BOOKS_ON_PAGE);
            maxPage = service.getMaxPage(filePath, COUNT_BOOKS_ON_PAGE);

            request.setAttribute("library", library);
            request.setAttribute("page", page);
            request.setAttribute("pageCount", maxPage);
            request.setAttribute("parseType", parseType);

            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    WorkerWithProperties.getOurInstance().getResponcePagePath());

            dispatcher.forward(request, response);

        } catch (ServiceSAXException | ServiceXMLStreamException | ServiceIOException ex) {
            Logger.getLogger(ParserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
