package servlet;

import entity.Person;
import service.PersonService;
import service.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(urlPatterns = "/person/list/name-and-phone", name = "personListNameAndPhone")
public class NameAndPhoneListPersonServlet extends HttpServlet {
    private PersonService person;

    @Override
    public void init() throws ServletException {
        Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
        person = new PersonServiceImpl(connection, Strategy.NAME_AND_PHONE);
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Person> res = person.getList();
        req.setAttribute("persons", res);
        req.setAttribute("PageTitle", "Students");
        req.setAttribute("PageBody", "persons_name_phone.jsp");
        req.getRequestDispatcher("/layout.jsp").forward(req, resp);
    }
}

