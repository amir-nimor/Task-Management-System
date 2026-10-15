package ir.maktabsharif.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.maktabsharif.dto.user.UserRequestDto;
import ir.maktabsharif.dto.user.UserResponseDto;
import ir.maktabsharif.repository.user.UserRepositoryImpl;
import ir.maktabsharif.service.user.UserServiceImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Register",value = "/Register")
public class UserServlet extends HttpServlet {

    private UserServiceImpl userService;
    private ObjectMapper objectMapper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.userService = new UserServiceImpl(new UserRepositoryImpl());
        this.objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("./page/SingUp.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserRequestDto userRequestDto = UserRequestDto.builder()
                .username(username)
                .password(password)
                .build();

        UserResponseDto userResponseDto = userService.save(userRequestDto);

        session.setAttribute("userId",userResponseDto.getId());

        Cookie cookie = new Cookie("username",username);
        resp.addCookie(cookie);

        resp.setStatus(201);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String json = objectMapper.writeValueAsString(userResponseDto);

        resp.getWriter().println(json);

    }
}
