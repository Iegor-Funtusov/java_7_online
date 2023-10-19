package ua.com.alevel;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
public class FinalProjectSupplierFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("auth-token");
        if (token == null) {
            response.sendError(401, "Token is not present");
            return;
        }
        if (!token.equals("a8a53779-8066-4bd0-84f5-ba738b0bbf77")) {
            response.sendError(401, "Token is not valid");
            return;
        }
        filterChain.doFilter(request, response);
    }
}
