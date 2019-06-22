package com.foxiswho.springbootjpademo.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class BaseServiceImpl<T, ID extends Serializable, R extends BaseRepository<T, ID>> implements BaseService<T, ID, R> {
    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected R baseRepository;

    public BaseServiceImpl() {
    }

    public Optional<T> findById(ID id) {
        return this.baseRepository.findById(id);
    }

    public R getRepository() {
        return this.baseRepository;
    }

    public T saveOne(T entity) {
        return this.saveOne(this.baseRepository, entity);
    }

    public <TT, TID extends Serializable> TT saveOne(BaseRepository<TT, TID> baseRepository, TT entity) {
        return baseRepository.save(entity);
    }

    public void deleteById(ID id) {
        this.baseRepository.deleteById(id);
    }

    public List<T> findAll(Example<T> example) {
        return this.baseRepository.findAll(example);
    }

    public List<T> findAll() {
        return this.baseRepository.findAll();
    }

    public Page<T> findAll(Pageable pageable) {
        return this.baseRepository.findAll(pageable);
    }
}
