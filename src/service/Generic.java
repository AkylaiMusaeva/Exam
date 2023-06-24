package service;

import java.util.List;

public interface Generic<T> {
    List<T> add(T t);
    List<T>getAll();

}
