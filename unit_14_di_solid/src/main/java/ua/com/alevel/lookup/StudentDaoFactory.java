package ua.com.alevel.lookup;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class StudentDaoFactory {

    private final static StudentDaoFactory studentDaoFactory = new StudentDaoFactory();
    private StudentDao studentDao;
    private Reflections reflections = new Reflections("ua.com.alevel");

    private StudentDaoFactory() {
        this.initDao();
    }

    public static StudentDaoFactory getFactory() {
        return studentDaoFactory;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    private void initDao() {
        Set<Class<? extends StudentDao>> subTypesOf = reflections.getSubTypesOf(StudentDao.class);
        for (Class<? extends StudentDao> aClass : subTypesOf) {
            if (aClass.isAnnotationPresent(UseClass.class)) {
                try {
                    Object o = aClass.getDeclaredConstructor().newInstance();
                    studentDao = (StudentDao) o;
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
