package ua.com.alevel.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

    private final SessionFactory sessionFactory;
    private static HibernateConfig hibernateConfig = new HibernateConfig();

    private HibernateConfig() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    public static HibernateConfig getInstance() {
        return hibernateConfig;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
