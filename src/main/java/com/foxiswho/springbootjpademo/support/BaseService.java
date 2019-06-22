package com.foxiswho.springbootjpademo.support;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID extends Serializable, R extends BaseRepository<T, ID>> {
    R getRepository();

    T saveOne(T entity);

    <TT, TID extends Serializable> TT saveOne(BaseRepository<TT, TID> baseRepository, TT entity);

    Optional<T> findById(ID id);

    void deleteById(ID id);

    List<T> findAll();

    List<T> findAll(Example<T> example);

    Page<T> findAll(Pageable pageable);
}

