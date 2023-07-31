package ua.com.alevel;

import ua.com.alevel.config.AppConfig;
import ua.com.alevel.factory.BeanFactory;

public class AlevelApplication {

    public static void start(Class<?> mainClass) {
        AppConfig appConfig = new AppConfig(mainClass);
        BeanFactory beanFactory = new BeanFactory(appConfig.getStore());
        beanFactory.initBeans();
        appConfig.configureBean(beanFactory.getBeanMap());
        ALevelStarter starter = new ALevelStarter();
        starter.start(beanFactory.getBeanMap());
    }
}
