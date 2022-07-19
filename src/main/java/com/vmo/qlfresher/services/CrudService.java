package com.vmo.qlfresher.services;

import java.util.List;

public interface CrudService <E> {
	E create(E e);
	E update(E e, int id);
	E getById(int id);
    List <E> getAll();
    String delete(int id);
}
