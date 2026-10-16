package ir.maktabsharif.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.maktabsharif.dto.auth.LogoutResponseDto;
import ir.maktabsharif.repository.auth.AuthRepository;
import ir.maktabsharif.service.auth.AuthService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "Logout", value = "/logout")
public class LogoutServlet extends HttpServlet {
    private AuthService authService;
    private ObjectMapper objectMapper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.authService = new AuthService(new AuthRepository());
        this.objectMapper = new ObjectMapper();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        session.invalidate();
        resp.setStatus(HttpServletResponse.SC_OK);
        LogoutResponseDto logoutResponseDto = new LogoutResponseDto("Logout successful.");
        String json = objectMapper.writeValueAsString(logoutResponseDto);

        objectMapper.writeValue(
                resp.getWriter(),
                json
        );

//        objectMapper.writeValue(
//                response.getWriter(),
//                Map.of("message", "Logout successful.")
//        );
    }
}
