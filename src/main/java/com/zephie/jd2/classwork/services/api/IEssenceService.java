package com.zephie.jd2.classwork.services.api;

import java.util.Optional;
import java.util.Set;

public interface IEssenceService<T> {
    Set<T> get();

    Optional<T> get(long id);

    void validate(T item);

    void save(T item);
}
