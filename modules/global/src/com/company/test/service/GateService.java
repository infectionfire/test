package com.company.test.service;

import com.company.test.entity.Planin;

import java.util.List;

public interface GateService {
    String NAME = "test_GateService";

    /**
     * Метод для получения списка всех доступных ворот в данный временной период
     * @return список номеров для установки в сущность планирования
     */
    List<String> findAvailableGateNumbers();


    /**
     * Установка статусов назначения ворот в приемку после выбора ворот
     * @param planin - Приемка
     * @param gateNumber - номер ворот
     */
    void postRegistredGate(Planin planin, String gateNumber);
}