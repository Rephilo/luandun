package com.rephilo.luandun.dao.db;

import com.rephilo.luandun.model.db.Book;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * 查询book信息dao
 *
 * @author rephilo
 */
public class BookRepository implements JpaRepository<Book, Integer> {
    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public List<Book> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Book> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Book book) {

    }

    @Override
    public void deleteAll(Iterable<? extends Book> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Book> S save(S s) {
        return null;
    }

    @Override
    public <S extends Book> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Book> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Book> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Book> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Book getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends Book> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Book> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Book> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Book> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Book> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Book> boolean exists(Example<S> example) {
        return false;
    }
}
