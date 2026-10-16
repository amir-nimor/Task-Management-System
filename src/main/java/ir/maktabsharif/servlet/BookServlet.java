package ir.maktabsharif.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.maktabsharif.command.BookCommand;
import ir.maktabsharif.dao.BookDao;
import ir.maktabsharif.dto.book.BookRequestDto;
import ir.maktabsharif.dto.book.BookResponseDto;
import ir.maktabsharif.exception.InvalidRequestException;
import ir.maktabsharif.repository.book.BookRepositoryImpl;
import ir.maktabsharif.service.book.BookService;
import ir.maktabsharif.service.book.BookServiceImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value = {"/book", "/book/*"})
public class BookServlet extends HttpServlet {
    private BookService bookService;
    private ObjectMapper objectMapper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.bookService = new BookServiceImpl(new BookRepositoryImpl());
        this.objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BookResponseDto> books = bookService.findAll();

        req.setAttribute("books", books);

        req.getRequestDispatcher("/page/book.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            BookRequestDto bookRequestDto = objectMapper.readValue(req.getReader(), BookRequestDto.class);

            bookService.save(bookRequestDto);
            resp.setStatus(HttpServletResponse.SC_CREATED);
        } catch (InvalidRequestException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // REGULAR EXPRESSION
            boolean isValid = req.getPathInfo().matches("^/\\d+$");
            if (!isValid) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            Integer bookId = Integer.parseInt(req.getPathInfo().substring(1));


            bookService.delete(bookId);
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
