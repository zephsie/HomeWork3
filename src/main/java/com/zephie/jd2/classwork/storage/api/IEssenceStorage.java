package com.zephie.jd2.classwork.storage.api;

import java.util.Optional;
import java.util.Set;

public interface IEssenceStorage<T> {
    Set<T> get();

    Optional<T> get(long id);

    void save(T item);
}