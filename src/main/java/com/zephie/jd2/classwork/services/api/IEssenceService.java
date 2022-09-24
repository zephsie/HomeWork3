package com.zephie.jd2.classwork.services.api;

import java.util.Collection;
import java.util.Optional;

public interface IEssenceService<T> {
    Collection<T> get();

    Optional<T> get(long id);
}
