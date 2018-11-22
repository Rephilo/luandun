package com.rephilo.luandun.dao.es;

import com.rephilo.luandun.model.Book;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

/**
 * ES操作类
 *
 * @author rephilo
 */
public class ESBookRepository implements ElasticsearchRepository<Book, Integer> {

    @Override
    public <S extends Book> S index(S s) {
        return null;
    }

    @Override
    public Iterable<Book> search(QueryBuilder queryBuilder) {
        return null;
    }

    @Override
    public Page<Book> search(QueryBuilder queryBuilder, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Book> search(SearchQuery searchQuery) {
        return null;
    }

    @Override
    public Page<Book> searchSimilar(Book book, String[] strings, Pageable pageable) {
        return null;
    }

    @Override
    public void refresh() {

    }

    @Override
    public Class<Book> getEntityClass() {
        return null;
    }

    @Override
    public Iterable<Book> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Book> S save(S s) {
        return null;
    }

    @Override
    public <S extends Book> Iterable<S> saveAll(Iterable<S> iterable) {
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
    public Iterable<Book> findAll() {
        return null;
    }

    @Override
    public Iterable<Book> findAllById(Iterable<Integer> iterable) {
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
}
