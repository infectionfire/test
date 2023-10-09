package com.company.test.service;

import com.company.test.entity.Planin;
import com.company.test.enums.LoadCapacity;

import java.util.List;

public interface PlaninService {
    String NAME = "test_PlaninService";


    /**
     * Метод для регистрации приемки
     * @param carNumber - номер машины
     * @param name - ФИО
     * @param phoneNumber - номер телефона
     * @param loadCapacity - загрузка
     */
    void createNewPlaninByRegisterField(String carNumber, String name, String phoneNumber, LoadCapacity loadCapacity);


    /**
     * Метод для завершения загрузки. Ставит статус и состояние "Выезд разрешен"
     * @param planin - сущность по которой велась приемка
     */
    void postLoadUpdate(Planin planin);


    /**
     * Метод для поиска приемок, которым следует установить статус "покинул" по истечению времени
     * @return Список приемок с истекшим периодом
     */
    List<Planin> findCandidatesToLeft();
}