package ua.com.alevel;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StringMain {
    public static void main(String[] args) {
        System.out.println("Hello StringMain!");
        String s = "test";

        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            System.out.println("c = " + c);
        }

        String ss = String.valueOf(charArray);
        System.out.println("ss = " + ss);

        System.out.println(s.equals(ss));

        String lowerCase = ss.toLowerCase();
        System.out.println("lowerCase = " + lowerCase);

        String upperCase = ss.toUpperCase();
        System.out.println("upperCase = " + upperCase);

        ss = "test11_test22";
        String[] s1 = ss.split("_");
        for (String s2 : s1) {
            System.out.println("s2 = " + s2);
        }

        String sss = lowerCase + upperCase;
        System.out.println("sss = " + sss);

        sss = lowerCase.concat(upperCase);
        System.out.println("sss = " + sss);

        boolean b = sss.startsWith("tee");
        System.out.println("b = " + b);

        boolean b1 = sss.endsWith("st");
        boolean b2 = sss.toLowerCase().endsWith("st");
        System.out.println("b2 = " + b2);

        b2 = StringUtils.endsWithIgnoreCase(sss, "st");
        System.out.println("b2 = " + b2);

        b2 = sss.equals("TestTEST");
        System.out.println("b2 = " + b2);

        b2 = sss.toLowerCase().equals("TestTEST".toLowerCase());
        System.out.println("b2 = " + b2);

        b2 = StringUtils.equalsIgnoreCase(sss, "TestTEST");
        System.out.println("b2 = " + b2);

        char c = sss.charAt(3);
        System.out.println("c = " + c);

        int i = sss.indexOf("TEST");
        System.out.println("i = " + i);

        sss = "   jghljgfljfj     ";
        System.out.println("sss = " + sss);
        String trim = sss.trim();
        System.out.println("trim = " + trim);

        sss = " ";

        System.out.println("isBlank = " + !sss.isBlank());
        System.out.println("isEmpty = " + !sss.isEmpty());

        System.out.println("isBlank = " +  StringUtils.isNotBlank(sss));
        System.out.println("isEmpty = " + StringUtils.isNotEmpty(sss));

        sss = "test1 test2 test3";

        String sub = sss.substring(4);
        System.out.println("sub = " + sub);
        sub = sss.substring(4, 7);
        System.out.println("sub = " + sub);

        String email = "bla@mail.comm";
        System.out.println("email = " + email);

        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        System.out.println("regex = " + email.matches(regex));

        String number = "123456";
        regex = "[0-9]+";
        System.out.println("regex = " + number.matches(regex));

        regex = "\\d+";
        System.out.println("regex = " + number.matches(regex));

        // table students

        List<Student> students = new ArrayList<>();
//        String sql = "select from students where ";
        StringBuilder sb = new StringBuilder("select from students where ");
        for (Student student : students) {
            if (student.getFirstName() != null) {
//                sql = sql.concat("first_name '%LIKE%' = " + student.getFirstName());
                sb = sb.append("first_name '%LIKE%' = ").append(student.getFirstName());
                // select from students where first_name '%LIKE%' = 'Ivan'
            }
            if (student.getLastName() != null) {
//                sql = sql.concat("and last_name '%LIKE%' = " + student.getLastName());
                sb = sb.append("last_name '%LIKE%' = ").append(student.getLastName());
                // select from students where first_name '%LIKE%' = 'Ivan and last_name '%LIKE%' = 'Ivanov''
            }
            if (student.getEmail() != null) {
//                sql = sql.concat("email '%LIKE%' = " + student.getEmail());
            }
            if (student.getAge() != 0) {
//                sql = sql.concat("age < " + student.getAge());
            }

            String sql = sb.toString();
        }
        StringBuilder stringBuilder = new StringBuilder("Test1 Test2");

        sss = stringBuilder.reverse().toString();
        System.out.println("sss = " + sss);

        sss = sss.replace("1t", "34J");
        System.out.println("sss = " + sss);
    }

    private static class Student {
        private String firstName;
        private String lastName;
        private String email;
        private int age;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
