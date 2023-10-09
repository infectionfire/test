package com.company.test.repository;

import com.haulmont.bali.util.Preconditions;
import com.haulmont.cuba.core.global.View;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

public interface BaseRepository<E> {

    /**
     * Метод подгружающий сущность по заданному View, позволяет подгрузить зависимые атррибуты от других таблиц
     *
     * @param entity - сущность
     * @param view   - представление загрузки сущности
     * @return подгруженная сущность
     */
    E loadExtendedEntityView(E entity, String view);

    /**
     * Метод подгружающий сущность с заданным View, позволяет подгрузить зависимые атрибуты от других таблиц
     *
     * @param entity - сущность
     * @param view   - представление загрузки сущности
     * @return подгруженная сущность
     */
    E loadExtendedEntityView(E entity, View view);

    /**
     * Метод для проверки объектов чтобы не были ни null ни empty
     *
     * @param objects - массив объектов
     */
    default void preconditions(Object... objects) {
        if (objects.length > 0) {
            for (Object object : objects) {
                if (object instanceof String)
                    Preconditions.checkNotEmptyString((String) object);
                else if (object instanceof List)
                    if (CollectionUtils.isEmpty((List) object)) throw new IllegalArgumentException("Empty collections");
                    else
                        Preconditions.checkNotNullArgument(object);
            }
        }
    }
}
