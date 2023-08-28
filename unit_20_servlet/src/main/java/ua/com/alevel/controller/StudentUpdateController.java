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

public class StudentUpdateController extends HttpServlet {

    private final StudentDao studentDao = new StudentDaoImpl();

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);

        String idParam = req.getParameter("id");
        Long id = Long.parseLong(idParam);
        Student student = studentDao.findById(id);

        try(PrintWriter writer = resp.getWriter()) {
            writer.write("<html>");
            writer.write("<body>");
            writer.write("<h1>Update Students</h1>");
            writer.write("<form method=\"post\" action=\"/test_servlet/students-update\">");
            writer.write("<table>");
            writer.write("<tr><td></td><td><input type='hidden' name='id' value='" + student.getId() + "'/></td></tr>");
            writer.write("<tr><td>Name:</td><td><input type='text' name='name' value='" + student.getName() + "'/></td></tr>");
            writer.write("<tr><td><input type='submit' value='Update'/></td></tr>");
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

        String idParam = req.getParameter("id");
        Long id = Long.parseLong(idParam);
        Student student = studentDao.findById(id);
        String name = req.getParameter("name");
        student.setName(name);
        studentDao.update(student);

        resp.sendRedirect("students");
    }
}
