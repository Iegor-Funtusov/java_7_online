package ua.com.alevel.query;

import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.annotations.Column;
import ua.com.alevel.annotations.Entity;
import ua.com.alevel.annotations.PK;

import java.lang.reflect.Field;
import java.util.Objects;

public class QueryHelper {

    public void createTable(Class<?> entity) {
        StringBuilder sb = new StringBuilder();
        sb.append("create table ");
        if (entity.isAnnotationPresent(Entity.class)) {
            Entity annotation = entity.getAnnotation(Entity.class);
            String tableName = annotation.name();
            if (StringUtils.isNotBlank(tableName)) {
                sb.append(tableName);
                sb.append(" ");
            }
        } else {
            sb.append(" " + (entity.getSimpleName() + "s ").toLowerCase());
        }
        sb.append("(");

        Class<?> superclass = entity.getSuperclass();
        if (Objects.nonNull(superclass)) {
            for (Field declaredField : superclass.getDeclaredFields()) {
                if (declaredField.isAnnotationPresent(PK.class)) {
                    sb.append(declaredField.getName());
                    sb.append(" ");
                    if (declaredField.getType().isAssignableFrom(Long.class)) {
                        sb.append("bigint auto_increment primary key,");
                    }
                }
            }
        }
        for (Field declaredField : entity.getDeclaredFields()) {
            if (declaredField.isAnnotationPresent(Column.class)) {
                Column column = declaredField.getAnnotation(Column.class);
                String columnName = column.name();
                if (StringUtils.isNotBlank(columnName)) {
                    sb.append(columnName);
                }
                sb.append(" ");
                if (declaredField.getType().isAssignableFrom(String.class)) {
                    sb.append("varchar(255),");
                    sb.append(" ");
                }
                if (declaredField.getType().isAssignableFrom(Integer.class)) {
                    sb.append("int,");
                    sb.append(" ");
                }
            } else {
                sb.append(declaredField.getName().toLowerCase());
                sb.append(" ");
                if (declaredField.getType().isAssignableFrom(String.class)) {
                    sb.append("varchar(255),");
                    sb.append(" ");
                }
                if (declaredField.getType().isAssignableFrom(Integer.class)) {
                    sb.append("int,");
                    sb.append(" ");
                }
            }
        }

        sb.append(")");


        System.out.println("sb = " + sb);
    }
}
