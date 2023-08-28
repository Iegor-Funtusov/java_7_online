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

public class StudentReviewController extends HttpServlet {

    private final StudentDao studentDao = new StudentDaoImpl();

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        try(PrintWriter writer = resp.getWriter()) {
            writer.write("<html>");
            writer.write("<body>");
            writer.write("<h1>All Students</h1>");
            writer.write("<table>");
            writer.write("<tr>");
            writer.write("<th>Id</th>");
            writer.write("<th>Name</th>");
            writer.write("<th>Update</th>");
            writer.write("</tr>");
            for (Student student : studentDao.findAll()) {
                writer.write("<tr>");
                writer.write("<td>");
                writer.write(student.getId().toString());
                writer.write("</td>");
                writer.write("<td>");
                writer.write(student.getName());
                writer.write("</td>");
                writer.write("<td>");
                writer.write("<a href=\"/test_servlet/students-update?id=" + student.getId() + "\">Update</a>");
                writer.write("</td>");
                writer.write("</tr>");
            }
            writer.write("</table>");
            writer.write("<a href=\"/test_servlet/students-new\">Create new student</a>");
            writer.write("</body>");
            writer.write("</html>");
        }
    }
}
