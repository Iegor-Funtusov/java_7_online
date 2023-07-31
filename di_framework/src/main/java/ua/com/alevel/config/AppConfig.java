package ua.com.alevel.config;

import org.reflections.Reflections;
import org.reflections.Store;
import ua.com.alevel.annotations.InjectBean;

import java.lang.reflect.Field;
import java.util.Map;

public class AppConfig {

    private final Reflections scanner;

    public AppConfig(Class<?> mainClass) {
        this.scanner = new Reflections(mainClass.getPackageName());
    }

    public void configureBean(final Map<Class<?>, Object> beanMap) {
        beanMap.values().forEach(bean -> {
            Field[] declaredFields = bean.getClass().getDeclaredFields();
            for (Field declaredField : declaredFields) {
                if (declaredField.isAnnotationPresent(InjectBean.class)) {
                    Class<?> type = declaredField.getType();
                    Object injectBean = beanMap.get(type);
                    declaredField.setAccessible(true);
                    try {
                        declaredField.set(bean, injectBean);
                    } catch (IllegalAccessException e) {
                        System.out.println("e = " + e);
                    }
                }
            }
        });
    }

    public Store getStore() {
        return scanner.getStore();
    }
}
