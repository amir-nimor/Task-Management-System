package ir.maktabsharif.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.maktabsharif.dto.book.BookRequestDto;
import ir.maktabsharif.dto.book.BookResponseDto;
import ir.maktabsharif.repository.book.BookRepositoryImpl;
import ir.maktabsharif.service.book.BookServiceImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "BokServlet",value = "/api/books/*")
public class BookServlet extends HttpServlet {


    private BookServiceImpl bookService;
    private ObjectMapper objectMapper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.bookService = new BookServiceImpl(new BookRepositoryImpl());
        this.objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<BookResponseDto> bookResponseDtos = bookService.findAll();

        resp.setStatus(200);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        this.objectMapper.writeValue(resp.getWriter(),bookResponseDtos);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BookRequestDto bookRequestDto = objectMapper.readValue(req.getReader(), BookRequestDto.class);

        BookResponseDto bookResponseDto = bookService.save(bookRequestDto);

        resp.setStatus(201);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        this.objectMapper.writeValue(resp.getWriter(),bookResponseDto);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();

        Integer id;

        if (Optional.ofNullable(path).isEmpty() || !path.matches("/\\d+")){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        id = Integer.parseInt(path.substring(1));

        BookRequestDto bookRequestDto = objectMapper.readValue(req.getReader(), BookRequestDto.class);
        bookRequestDto.setId(id);

        BookResponseDto bookResponseDto = bookService.update(bookRequestDto);

        objectMapper.writeValue(resp.getWriter(),bookResponseDto);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
