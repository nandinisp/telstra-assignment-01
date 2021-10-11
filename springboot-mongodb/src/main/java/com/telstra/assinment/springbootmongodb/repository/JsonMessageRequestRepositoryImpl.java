package com.telstra.assinment.springbootmongodb.repository;

import com.telstra.assinment.springbootmongodb.model.JsonMessageRequest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class JsonMessageRequestRepositoryImpl implements JsonMessageRequestRepository {
    @Override
    public <S extends JsonMessageRequest> S save(S entity) {
        return null;
    }

    @Override
    public <S extends JsonMessageRequest> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<JsonMessageRequest> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<JsonMessageRequest> findAll() {
        return null;
    }

    @Override
    public Iterable<JsonMessageRequest> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(JsonMessageRequest entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends JsonMessageRequest> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<JsonMessageRequest> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<JsonMessageRequest> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends JsonMessageRequest> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends JsonMessageRequest> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends JsonMessageRequest> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends JsonMessageRequest> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends JsonMessageRequest> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends JsonMessageRequest> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends JsonMessageRequest> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends JsonMessageRequest> boolean exists(Example<S> example) {
        return false;
    }
}
