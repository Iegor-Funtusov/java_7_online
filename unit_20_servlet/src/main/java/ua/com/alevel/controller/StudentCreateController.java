package ua.com.alevel.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.dao.impl.StudentDaoImpl;
import ua.com.alevel.entity.Student;

import java.io.IOException;
import java.io.PrintWriter;

public class StudentCreateController extends HttpServlet {

    private final StudentDao studentDao = new StudentDaoImpl();

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);

        try(PrintWriter writer = resp.getWriter()) {
            writer.write("<html>");
            writer.write("<body>");
            writer.write("<h1>New Students</h1>");
            writer.write("<form method=\"post\" action=\"/test_servlet/students-new\">");
            writer.write("<table>");
            writer.write("<tr><td>Name:</td><td><input type='text' name='name'/></td></tr>");
            writer.write("<tr><td><input type='submit' value='Create'/></td></tr>");
            writer.write("</table>");
            writer.write("</form>");
            writer.write("</body>");
            writer.write("</html>");
        }
    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(201);

        String name = req.getParameter("name");
        Student student = new Student();
        student.setName(name);
        studentDao.create(student);

        resp.sendRedirect("students");
    }
}
