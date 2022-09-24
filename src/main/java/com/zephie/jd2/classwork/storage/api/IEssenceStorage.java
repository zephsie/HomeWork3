package com.zephie.jd2.classwork.storage.api;

import java.util.Collection;
import java.util.Optional;

public interface IEssenceStorage<T> {
    Collection<T> get();

    Optional<T> get(long id);

    void save(T item);

    long getCount();
}