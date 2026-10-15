package ir.maktabsharif.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.maktabsharif.dto.user.UserResponseDto;
import ir.maktabsharif.repository.auth.AuthRepository;
import ir.maktabsharif.repository.user.UserRepositoryImpl;
import ir.maktabsharif.service.auth.AuthService;
import ir.maktabsharif.service.user.UserServiceImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "Login", value = "/login")
public class LoginServlet extends HttpServlet {
    private AuthService authService;
    private ObjectMapper objectMapper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.authService = new AuthService(new AuthRepository());
        this.objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("./page/Login.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username == null || password == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        UserResponseDto userResponseDto = authService.loginWithUsernameAndPassword(username, password);

        HttpSession session = req.getSession();
        session.setAttribute("userId", userResponseDto.getId());

        Cookie cookie = new Cookie("username", userResponseDto.getUsername());
        resp.addCookie(cookie);

        resp.sendRedirect("/profile");
    }

}
