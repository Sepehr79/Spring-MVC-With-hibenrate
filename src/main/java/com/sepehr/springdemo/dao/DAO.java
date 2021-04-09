package com.sepehr.springdemo.dao;

import java.util.List;

public interface DAO<DT> {

    public void save(DT reference);

    public void saveOrUpdate(DT reference);

    public DT getReferenceById(Object id);

    public DT getReferencesBySpecialValue(Object value);

    public List<DT> getReferences();

    public void update(DT references);

    public void delete(DT references);

    public void reset();
}
