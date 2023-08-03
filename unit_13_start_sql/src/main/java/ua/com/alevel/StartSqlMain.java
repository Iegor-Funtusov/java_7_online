package ua.com.alevel;

import ua.com.alevel.entity.Employee;
import ua.com.alevel.query.QueryHelper;

public class StartSqlMain {

    public static void main(String[] args) {
//        StartApp startApp = new StartApp();
//        startApp.run();

        QueryHelper qh = new QueryHelper();
        qh.createTable(Employee.class);
    }
}
