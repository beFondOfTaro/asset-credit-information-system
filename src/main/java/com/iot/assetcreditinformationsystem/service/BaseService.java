package com.iot.assetcreditinformationsystem.service;

import java.util.List;

public interface BaseService<T> {

    List<T> findAll();

    T save(T entity);

    T findOne(Integer id);

    T update(T entity);

    void delete(Integer id);
}
