package com.salesianostriana.dam.service;

import java.util.List;
import java.util.Optional;

public interface IBaseService<T, ID> {
    
    List<T> findAll();
    
    Optional<T> findById(ID id);
    
    T save(T t);
    
    T edit(T t);
    
    void delete(T t);
    
    void deleteById(ID id);
}